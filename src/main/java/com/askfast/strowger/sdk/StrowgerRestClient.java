package com.askfast.strowger.sdk;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import com.askfast.strowger.sdk.model.Address;
import com.askfast.strowger.sdk.model.AddressConfig;
import com.askfast.strowger.sdk.model.Call;
import com.askfast.strowger.sdk.model.Dial;
import com.askfast.strowger.sdk.model.RequestLog;
import com.askfast.strowger.sdk.model.StrowgerResponse;
import com.askfast.strowger.sdk.rest.StrowgerRestInterface;
import com.askfast.strowger.util.JOM;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

public class StrowgerRestClient {

    private Logger log = Logger.getLogger( StrowgerRestClient.class.getName() );
    private static OkHttpClient httpClient = new OkHttpClient();
    
    public static final String DEFAULT_ENDPOINT = "https://strowger.thinkingphones.com";

    private String tenantKey = null;
    private String token = null;
    private String endpoint = null;
    
    private StrowgerRestInterface service;
    private Boolean isDev;
    
    /**
     * Creates an AskFastRestClient instance.
     * @param tenantKey Your tenantKey
     * @param token Your token
     * @param isDev Logs some header and body sent if True
     */
    public StrowgerRestClient(final String tenantKey, final String token, final Boolean isDev) {
        this(tenantKey, token, null, isDev);
    }
    
    
    /**
     * Creates an StrowgerRestClient instance. Be sure the token is valid, otherwise any request will fail and most
     * likely throw an exception.
     *
     * @param tenantKey Your tenantKey
     * @param token Your token
     * @param endpoint The endpoint, the url of API endpoint you wish to use. (The default is set to: https://strowger.thinkingphones.com)
     * @param isDev Logs some header and body sent if True
     */
    public StrowgerRestClient(final String tenantKey, final String token, final String endpoint, final Boolean isDev) {
        this.tenantKey = tenantKey;
        this.token = token;
        this.endpoint = endpoint;
        this.isDev = isDev;
        
        if(endpoint==null) {
            this.endpoint = DEFAULT_ENDPOINT;
        }
    }
    
    /**
     * Check if the given number exists in Strowger
     * @param number Number that is looked up
     * @return True if found, false if not found.
     */
    public boolean addressExists(String number) {
        Address address = null;
        try {
            address = getAddress( number );
        }
        catch ( IOException e ) {
            log.warning("Failed to load address: " + number);
        }
        if(address != null) {
            return true;
        }
        return false;
    }
    
    /**
     * Retrieves a DID by number
     * @param number The number for which the DID must be retrieved
     * @return Address The retrived address if found, else returns null
     * @throws IOException This exception is thrown if the endpoint is not reachable
     */
    public Address getAddress(String number) throws IOException {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<Address>> address = service.getAddress( tenantKey, number ).execute();
        if(!address.isSuccess()) {
            return null;
        }
        return address.body().getData();
    }
    
    /**
     * Retrieves a list of all the DIDs
     * @return A list of addresses that are available for the tenant
     * @throws IOException This exception is thrown if the endpoint is not reachable
     */
    public List<Address> getAddresses() throws IOException {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<List<Address>>> addresses = service.getAddresses( tenantKey ).execute();
        return addresses.body().getData();
    }
    
    /**
     * Configure a DID
     * @param address address to be configured
     * @param addressConfig The config which is linked to the given address
     * @return Address The address that is configured if the given number is found
     * @throws IOException This exception is thrown if the endpoint is not reachable
     */
    public Address configureAddress(String address, AddressConfig addressConfig) throws IOException {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<Address>> res = service.configureAddress( tenantKey, address, addressConfig ).execute();
        if(!res.isSuccess()) {
            return null;
        }
        return res.body().getData();
    }
    
    /**
     * Initiate a phone from a DID to a Peer or list of Peers
     * @param address Address for initiating a call
     * @param dial The action needed to be performed when the call is performed
     * @return The Call that is triggered. Also contains the callId
     */
    public Call initiateCall(String address, Dial dial) {

        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<Call>> res = null;
        try {
            log.info(String.format("Call requested with payload: %s", JOM.getInstance().writeValueAsString(dial)));
            res = service.initiateCall(tenantKey, address, dial).execute();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (res != null) {
            if (!res.isSuccess()) {
                log.warning("Failed to initiate call. Error code: " + res.code());
                return null;
            }
            StrowgerResponse<Call> sRes = res.body();
            if (sRes.getStatus() != 0) {
                log.warning("Failed to initiate call. Msg: " + sRes.getMsg() + " code: " + sRes.getStatus());
                return null;
            }
            return res.body().getData();
        }
        else {
            log.severe("Failed to initiate call. No response received");
            return null;
        }
    }
    
    /**
     * Retrieve request logs of a call
     * @param callId of the request logs
     * @return request logs of a call
     */
    public List<RequestLog> getRequestLogs(String callId) {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<List<RequestLog>>> res = null;
        try {
            res = service.getRequestLogs( tenantKey, callId).execute();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        if(!res.isSuccess()) {
            log.warning( "Failed to get request logs. Error code: " + res.code() );
            return null;
        }
        
        StrowgerResponse<List<RequestLog>> sRes = res.body();
        if(sRes.getStatus() != 0) {
            log.warning( "Failed to get request logs. Msg: " + sRes.getMsg() + " code: " + sRes.getStatus() );
            return null;
        }
        
        return res.body().getData();
    }

    /**
     * Retrieves a RestAdapter and instantiates an AskFastRestService instance.
     *
     * @return An AskFastRestService instance
     */
    private StrowgerRestInterface getRestInterface() {

        if (Boolean.TRUE.equals(isDev)) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.interceptors().add(interceptor);
        }
        httpClient.interceptors().add(new Interceptor() {

            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {

                Builder builder = chain.request().newBuilder();
                builder.removeHeader("Authorization");
                builder.removeHeader("Content-Type");
                Request request = builder.addHeader("Authorization", "Bearer " + token)
                                         .addHeader("Content-Type", "application/json").build();
                if (Boolean.TRUE.equals(isDev)) {
                    log.info(String.format("Tokens added.. %s",
                        JOM.getInstance().writeValueAsString(request.headers("Authorization"))));
                }
                Response response = chain.proceed(request);
                return response;
            }
        });
        if (service == null) {
            ObjectMapper om = JOM.getInstance();
            Retrofit build = new Retrofit.Builder().baseUrl(endpoint).client(httpClient)
                                                   .addConverterFactory(JacksonConverterFactory.create(om)).build();
            service = build.create(StrowgerRestInterface.class);
        }
        return service;
    }
}
