package com.askfast.strowger.sdk.rest;


import java.util.List;

import com.askfast.strowger.sdk.model.StrowgerResponse;
import com.askfast.strowger.sdk.resources.AddressConfig;
import com.askfast.strowger.sdk.resources.CallLog;
import com.askfast.strowger.sdk.resources.Dial;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface StrowgerRestInterface {

    @GET("/tenants/{tenantKey}/endpoints/addresses")
    public Call<StrowgerResponse<List<String>>> getAddresses(@Path("tenantKey") String tenantKey);
    
    @POST("/tenants/{tenantKey}/endpoints/addresses/{addressNumber}/config")
    public Call<StrowgerResponse<AddressConfig>> configureAddress(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address, @Body AddressConfig config);
    
    @DELETE("/tenants/{tenantKey}/endpoints/addresses/{addressNumber}/config")
    public Call<StrowgerResponse<String>> deleteAddressConfig(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address);
    
    @POST("/tenants/{tenantKey}/addresses/{addressNumber}/dial")
    public Call<StrowgerResponse<String>> initiateCall(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address, @Body Dial dial);
    
    @GET("/tenants/{tenantKey}/calls")
    public Call<StrowgerResponse<List<CallLog>>> getCallLogs(@Path("tenantKey") String tenantKey);
    
    @GET("/tenants/{tenantKey}/endpoints/addresses/{addressNumber}/calls")
    public Call<StrowgerResponse<List<CallLog>>> getCallLogsByAddress(@Path("tenantKey") String tenantKey, @Path("addressNumber") String address);
}