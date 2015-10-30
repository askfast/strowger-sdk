package com.askfast.strowger.sdk;

import java.io.IOException;
import java.util.List;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

import com.askfast.strowger.sdk.model.StrowgerResponse;
import com.askfast.strowger.sdk.resources.AddressConfig;
import com.askfast.strowger.sdk.resources.Dial;
import com.askfast.strowger.sdk.rest.StrowgerRestInterface;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class StrowgerRestClient {

    private static OkHttpClient httpClient = new OkHttpClient();
    
    public static final String DEFAULT_ENDPOINT = "https://strowger.thinkingphones.com";

    private String tenantKey = null;
    private String token = null;
    private String endpoint = null;
    
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
    
    /**
     * Retrieves a list of all the DIDs
     * @return List<String>
     * @throws IOException
     */
    public List<String> getAddresses() throws IOException {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<List<String>>> addresses = service.getAddresses( tenantKey ).execute();
        return addresses.body().getData();
    }
    
    /**
     * Configure a DID
     * @param address
     * @param addressConfig
     * @return
     * @throws IOException
     */
    public AddressConfig configureAddress(String address, AddressConfig addressConfig) throws IOException {
        StrowgerRestInterface service = getRestInterface();
        return service.configureAddress( tenantKey, address, addressConfig ).execute().body().getData();
    }
    
    /**
     * Initiate a phone from a DID to a Peer or list of Peers
     * @param address
     * @param dial
     * @return
     */
    public String initiateCall(String address, Dial dial) {
        StrowgerRestInterface service = getRestInterface();
        retrofit.Response<StrowgerResponse<String>> res = null;
        try {
            res = service.initiateCall( tenantKey, address, dial ).execute();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        
        return res.body().getData();
    }

    /**
     * Retrieves a RestAdapter and instantiates an AskFastRestService instance.
     *
     * @return An AskFastRestService instance
     */
    private StrowgerRestInterface getRestInterface() {
        final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(endpoint).addConverterFactory(JacksonConverterFactory.create());
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
        
        return retrofit.create(StrowgerRestInterface.class);
    }
}
