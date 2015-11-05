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
}
