package com.askfast.strowger.sdk;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askfast.strowger.sdk.model.StrowgerResponse;
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
        
        List<String> data = new ArrayList<>();
        data.add( "+31612345678" );
        
        StrowgerResponse<List<String>> resp = new StrowgerResponse<>( data );
        server.enqueue(new MockResponse().setBody(resp.toJson()));

        StrowgerRestClient client = new StrowgerRestClient(key, token, baseUrl.toString());
        List<String> addresses = client.getAddresses();
        
        assertEquals(data, addresses);
        
        RecordedRequest request1 = server.takeRequest();
        assertEquals("/tenants/" +  key + "/endpoints/addresses", request1.getPath());
        assertEquals("Bearer " + token, request1.getHeader("Authorization"));
    }
    
    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }
}
