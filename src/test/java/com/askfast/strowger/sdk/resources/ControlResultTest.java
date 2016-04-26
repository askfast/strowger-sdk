package com.askfast.strowger.sdk.resources;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.Date;
import org.junit.Test;
import com.askfast.strowger.sdk.model.Call;
import com.askfast.strowger.sdk.model.ControlResult;
import com.askfast.strowger.util.JOM;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControlResultTest{

    @Test
    public void parseJson() throws JsonParseException, JsonMappingException, IOException {
        
        ObjectMapper om = JOM.getInstance();
        
        String callId = "180143986476043840";
        String caller = "+31203004000";
        String called = "+31205301010";
        String callType = "incoming";
        Date date = om.readValue( "\"2015-11-04T10:59:49.149Z\"", Date.class);
        
        String json = "{\"call\":{\"callId\":" + callId + ",\"caller\":\"+31203004000\",\"called\":\"+31205301010\",\"callType\":\"incoming\",\"dialTime\":\"2015-11-04T10:59:49.149Z\",\"connectTime\":\"2015-11-04T10:59:49.149Z\",\"terminationTime\":\"2015-11-04T10:59:56.17Z\",\"dialedPeers\":[],\"originName\":\"asterisk\",\"originCallId\":\"1446634764.63\",\"originAddress\":\"10.224.128.74\",\"tenantId\":\"askfast\",\"serviceId\":1010,\"endpointAddress\":\"+31205301010\"}}";
        ControlResult res = ControlResult.fromJson( json );
        Call call = res.getCall();
        
        assertEquals( callId, call.getCallId() );
        assertEquals( caller, call.getCaller() );
        assertEquals( called, call.getCalled() );
        assertEquals( callType, call.getCallType() );
        assertEquals( date.toString(), call.getDialTime().toString());
    }
    
    @Test
    public void parseJsonWithDialedPeers() throws Exception {
        
        String callId = "180143986476043840";
        String caller = "testCaller";
        String called = "testCalled";
        String callType = "testCallType";
        String dateString = "2015-11-04T10:59:49.149Z";
        Date date = JOM.getInstance().readValue( "\"" + dateString + "\"", Date.class);
        
        String json = String.format("{\n" + 
            "    \"call\": {\n" + 
            "        \"callId\": %s,\n" + 
            "        \"caller\": \"%s\",\n" + 
            "        \"called\": \"%s\",\n" + 
            "        \"callType\": \"%s\",\n" + 
            "        \"dialTime\": \"%s\",\n" + 
            "        \"connectTime\": \"2015-12-18T15:30:49.148Z\",\n" + 
            "        \"terminationTime\": \"2015-12-18T15:31:39.900Z\",\n" + 
            "        \"dialedPeers\": [\n" + 
            "            {\n" + 
            "                \"dialedPeers\": [\n" + 
            "                    \"+31614765863\"\n" + 
            "                ],\n" + 
            "                \"connectedPeer\": \"+31614765863\",\n" + 
            "                \"dialTime\": \"%s\",\n" + 
            "                \"connectTime\": \"2015-12-18T15:30:49.148Z\",\n" + 
            "                \"terminationTime\": \"2015-12-18T15:31:39.818Z\",\n" + 
            "                \"channelHost\": \"10.224.128.54\",\n" + 
            "                \"channelId\": \"1450452629.259\"\n" + 
            "            }\n" + 
            "        ],\n" + 
            "        \"originName\": \"asterisk\",\n" + 
            "        \"originCallId\": \"1450452627.258\",\n" + 
            "        \"originAddress\": \"10.132.10.48\",\n" + 
            "        \"tenantId\": \"askfast\",\n" + 
            "        \"serviceId\": 313342,\n" + 
            "        \"endpointAddress\": \"+31858882010\",\n" + 
            "        \"disposition\": \"answered\"\n" + 
            "    }\n" + 
            "}", callId, caller, called, callType, dateString, dateString);
        ControlResult res = ControlResult.fromJson(json);
        Call call = res.getCall();
        
        assertEquals( callId, call.getCallId() );
        assertEquals( caller, call.getCaller() );
        assertEquals( called, call.getCalled() );
        assertEquals( callType, call.getCallType() );
        assertEquals( date.toString(), call.getDialTime().toString());
    }
}
