package com.askfast.strowger.sdk;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askfast.strowger.sdk.model.Address;
import com.askfast.strowger.sdk.model.Call;
import com.askfast.strowger.sdk.model.Dial;
import com.askfast.strowger.sdk.model.StrowgerResponse;
import com.askfast.strowger.util.JOM;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

public class StrowgerRestClientTest{

    private MockWebServer server = new MockWebServer();
    private HttpUrl baseUrl;
    
    private String key = "key";
    private String token = "token";
    
    @Before
    public void setup() throws IOException {
        // Start the server.
        server.start();
        baseUrl = server.url("/");
    }
    
    @Test
    public void getAddresses() throws InterruptedException, IOException {
        
        List<Address> data = new ArrayList<>();
        data.add( new Address("+31612345678",  "strowger", null) );
        
        StrowgerResponse<List<Address>> resp = new StrowgerResponse<>( data );
        server.enqueue(new MockResponse().setBody(resp.toJson()));

        StrowgerRestClient client = new StrowgerRestClient(key, token, baseUrl.toString());
        List<Address> addresses = client.getAddresses();
        
        for(int i=0; i<data.size(); i++) {
            assertEquals(data.get(i).getAddress(), addresses.get(i).getAddress());
        }
        
        RecordedRequest request1 = server.takeRequest();
        assertEquals("/tenants/" +  key + "/endpoints", request1.getPath());
        assertEquals("Bearer " + token, request1.getHeader("Authorization"));
    }
    
    @Test
    public void getAddress() throws InterruptedException, IOException {
        
        String number1 = "+31612345678";
        String number2 = "+31611111111";
        Address expectedAddresses = new Address(number1,  "strowger", null);
        
        StrowgerResponse<Address> resp1 = new StrowgerResponse<>( expectedAddresses );
        server.enqueue(new MockResponse().setBody(resp1.toJson()));
        StrowgerResponse<Address> resp2 = new StrowgerResponse<>();
        resp2.setStatus( 1025 );
        resp2.setMsg( "Unkown error: null" );
        server.enqueue(new MockResponse().setBody(resp2.toJson()).setResponseCode( 404));

        StrowgerRestClient client = new StrowgerRestClient(key, token, baseUrl.toString());
        Address address1 = client.getAddress(number1);
        
        assertEquals(expectedAddresses.getAddress(), address1.getAddress());
        
        RecordedRequest request1 = server.takeRequest();
        assertEquals("/tenants/" +  key + "/endpoints/" + number1, request1.getPath());
        assertEquals("Bearer " + token, request1.getHeader("Authorization"));
        
        Address address2 = client.getAddress(number2);
        assertNull(address2);
        
        RecordedRequest request2 = server.takeRequest();
        assertEquals("/tenants/" +  key + "/endpoints/" + number2, request2.getPath());
        assertEquals("Bearer " + token, request1.getHeader("Authorization"));
    }
    
    @Test
    public void initiateCall() throws InterruptedException {
        String caller = "+31205301000";
        String called = "+31203004000";
        String callJson = "{\"callId\":180143985464872500,\"caller\":\"" + caller + "\",\"called\":\"+31203004000\",\"callType\":\"outgoing\",\"dialTime\":\"2015-11-03T13:35:48.541Z\",\"connectTime\":null,\"terminationTime\":null,\"dialedPeers\":[],\"serviceId\":1000}";
        Call expectedCall = fromJson( callJson, Call.class );
        StrowgerResponse<Call> resp1 = new StrowgerResponse<>( expectedCall );
        server.enqueue(new MockResponse().setBody(resp1.toJson()));
        
        StrowgerResponse<Call> resp2 = new StrowgerResponse<>( expectedCall );
        resp2.setMsg( "Test err" );
        resp2.setStatus( 1025 );
        server.enqueue(new MockResponse().setBody(resp2.toJson()));
        
        Dial dial = new Dial(caller, called);
        
        StrowgerRestClient client = new StrowgerRestClient(key, token, baseUrl.toString());
        Call call1 = client.initiateCall( caller, dial);
        
        assertEquals(expectedCall.getCallId(), call1.getCallId());
        
        RecordedRequest request1 = server.takeRequest();
        assertEquals("/tenants/" +  key + "/endpoints/" + caller + "/calls", request1.getPath());
        assertEquals("Bearer " + token, request1.getHeader("Authorization"));
        
        Call call2 = client.initiateCall( caller, dial);
        assertNull(call2);
    }
    
    private <T> T fromJson(String json, Class<T> classType) {
        ObjectMapper om = JOM.getInstance();
        T result = null;
        try {
            result = om.readValue( json, classType );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }
}
