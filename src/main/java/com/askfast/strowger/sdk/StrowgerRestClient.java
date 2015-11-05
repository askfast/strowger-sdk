package com.askfast.strowger.sdk;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

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
import com.squareup.okhttp.Response;

public class StrowgerRestClient {

    private Logger log = Logger.getLogger( StrowgerRestClient.class.getName() );
    private static OkHttpClient httpClient = new OkHttpClient();
    
    public static final String DEFAULT_ENDPOINT = "https://strowger.thinkingphones.com";

    private String tenantKey = null;
    private String token = null;
    private String endpoint = null;
    
    private StrowgerRestInterface service;
    
    /**
     * Creates an AskFastRestClient instance.
     *
     * @param tenantKey
     *         Your tenantKey
     * @param token
     *         Your token
     */
    public StrowgerRestClient(final String tenantKey, final String token) {
        this(tenantKey, token, null);
    }
    
    
    /**
     * Creates an StrowgerRestClient instance. Be sure the token is valid, otherwise any request will fail and most
     * likely throw an exception.
     *
     * @param tenantKey
     *         Your tenantKey
     * @param token
     *         Your token
     * @param endpoint
     *         The endpoint, the url of API endpoint you wish to use. (The default is set to: https://api.thinkingphones.com)
     */
    public StrowgerRestClient(final String tenantKey, final String token, final String endpoint) {
        this.tenantKey = tenantKey;
        this.token = token;
        this.endpoint = endpoint;
        
        if(endpoint==null) {
            this.endpoint = DEFAULT_ENDPOINT;
        }
    }
    
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
     * @param number
     * @return Address
     * @throws IOException
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
     * @return List<Address>
     * @throws IOException
     */
    public List<Address> getAddresses() throws IOException {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<List<Address>>> addresses = service.getAddresses( tenantKey ).execute();
        return addresses.body().getData();
    }
    
    /**
     * Configure a DID
     * @param address
     * @param addressConfig
     * @return Address
     * @throws IOException
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
     * @param address
     * @param dial
     * @return
     */
    public Call initiateCall(String address, Dial dial) {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<Call>> res = null;
        try {
            res = service.initiateCall( tenantKey, address, dial).execute();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        if(!res.isSuccess()) {
            log.warning( "Failed to initiate call. Error code: " + res.code() );
            return null;
        }
        
        StrowgerResponse<Call> sRes = res.body();
        if(sRes.getStatus() != 0) {
            log.warning( "Failed to initiate call. Msg: " + sRes.getMsg() + " code: " + sRes.getStatus() );
            return null;
        }
        
        return res.body().getData();
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
        if(service == null) {
            ObjectMapper om = JOM.getInstance();
            final Retrofit.Builder builder = new Retrofit.Builder()
                                                        .baseUrl(endpoint)
                                                        .addConverterFactory(JacksonConverterFactory.create(om));
            httpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    return chain.proceed( request.newBuilder()
                    .addHeader( "Authorization", "Bearer " + token )
                    .build());
                }
            });
            
            Retrofit retrofit = builder.client( httpClient ).build();
            
            service = retrofit.create(StrowgerRestInterface.class);
        }
        return service;
    }
}
