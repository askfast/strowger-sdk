package com.askfast.strowger.sdk.rest;


import java.util.List;
import com.askfast.strowger.sdk.model.Address;
import com.askfast.strowger.sdk.model.AddressConfig;
import com.askfast.strowger.sdk.model.Dial;
import com.askfast.strowger.sdk.model.RequestLog;
import com.askfast.strowger.sdk.model.StrowgerResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface StrowgerRestInterface {

    @GET("/tenants/{tenantKey}/endpoints")
    public Call<StrowgerResponse<List<Address>>> getAddresses(@Path("tenantKey") String tenantKey);
    
    @GET("/tenants/{tenantKey}/endpoints/{address}")
    public Call<StrowgerResponse<Address>> getAddress(@Path("tenantKey") String tenantKey, @Path("address") String address);
    
    @POST("/tenants/{tenantKey}/endpoints/{addressNumber}/config")
    public Call<StrowgerResponse<Address>> configureAddress(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address, @Body AddressConfig config);
    
    @DELETE("/tenants/{tenantKey}/endpoints/{addressNumber}/config")
    public Call<StrowgerResponse<String>> deleteAddressConfig(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address);
    
    @POST("/tenants/{tenantKey}/endpoints/{addressNumber}/calls")
    public Call<StrowgerResponse<com.askfast.strowger.sdk.model.Call>> initiateCall(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address, @Body Dial dial);
    
    @GET("/tenants/{tenantKey}/calls")
    public Call<StrowgerResponse<List<com.askfast.strowger.sdk.model.Call>>> getCallLogs(@Path("tenantKey") String tenantKey);
    
    @GET("/tenants/{tenantKey}/endpoints/addresses/{addressNumber}/calls")
    public Call<StrowgerResponse<List<com.askfast.strowger.sdk.model.Call>>> getCallLogsByAddress(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address);
    
    @GET("/tenants/{tenantKey}/calls/{callId}/requests")
    public Call<StrowgerResponse<List<RequestLog>>> getRequestLogs(@Path("tenantKey") String tenantKey, @Path("callId") String callId);
}