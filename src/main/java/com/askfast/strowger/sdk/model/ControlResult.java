package com.askfast.strowger.sdk.model;

import java.io.IOException;
import com.askfast.strowger.util.JOM;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ControlResult {
    
    private Call call;
    private String dtmf;
    private String recordUrl;
    private DtmfFinishReason dtmfFinishReason; 
    private String dialResult;
    
    public ControlResult() {}
    
    public ControlResult(Call call) {
        this.call = call;
        this.dtmf = null;
        this.recordUrl = null;
    }
    
    public ControlResult(Call call, String dtmf) {
        this.call = call;
        this.dtmf = dtmf;
        this.recordUrl = null;
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
    
    public String getRecordUrl() {
        return recordUrl;
    }
    
    public void setRecordingUrl( String recordUrl ) {
        this.recordUrl = recordUrl;
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

    public DtmfFinishReason getDtmfFinishReason() {

        return dtmfFinishReason;
    }

    public void setDtmfFinishReason(DtmfFinishReason dtmfFinishReason) {

        this.dtmfFinishReason = dtmfFinishReason;
    }

    public String getDialResult() {

        return dialResult;
    }

    public void setDialResult(String dialResult) {

        this.dialResult = dialResult;
    }
}
