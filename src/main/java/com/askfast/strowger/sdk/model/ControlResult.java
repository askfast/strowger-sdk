package com.askfast.strowger.sdk.model;

import java.io.IOException;

import com.askfast.strowger.util.JOM;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControlResult {
    
    private Call call;
    private String dtmf;
    private String recordingUrl;
    
    public ControlResult() {}
    
    public ControlResult(Call call) {
        this.call = call;
        this.dtmf = null;
        this.recordingUrl = null;
    }
    
    public ControlResult(Call call, String dtmf) {
        this.call = call;
        this.dtmf = dtmf;
        this.recordingUrl = null;
    }
    
    public static ControlResult fromJson(String json) {
        ObjectMapper om = JOM.getInstance();
        ControlResult result = null;
        try {
            result = om.readValue( json, ControlResult.class );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Call getCall() {
        return call;
    }
    
    public void setCall( Call call ) {
        this.call = call;
    }
    
    public String getDtmf() {
        return dtmf;
    }
    
    public void setDtmf( String dtmf ) {
        this.dtmf = dtmf;
    }
    
    public String getRecordingUrl() {
        return recordingUrl;
    }
    
    public void setRecordingUrl( String recordingUrl ) {
        this.recordingUrl = recordingUrl;
    }
    
    @JsonIgnore
    public String toJson() {
        ObjectMapper om = JOM.getInstance();
        String result = null;
        try {
            result = om.writeValueAsString( this );
        }
        catch ( JsonProcessingException e ) {
            e.printStackTrace();
        }
        return result;
    }
}
