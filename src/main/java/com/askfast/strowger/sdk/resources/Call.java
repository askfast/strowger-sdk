package com.askfast.strowger.sdk.resources;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Call{

    private String id;
    private String caller;
    private String called;
    private String type;
    private String digits;
    private String audioUrl;
    private String status;
    
    public Call() {}
    
    public static Call fromJson(String json) {
        ObjectMapper om = new ObjectMapper();
        Call call = null;
        try {
            call = om.readValue( json, Call.class );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return call;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId( String id ) {
        this.id = id;
    }
    
    public String getCaller() {
        return caller;
    }
    
    public void setCaller( String caller ) {
        this.caller = caller;
    }
    
    public String getCalled() {
        return called;
    }
    
    public void setCalled( String called ) {
        this.called = called;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType( String type ) {
        this.type = type;
    }
    
    public String getDigits() {
        return digits;
    }
    
    public void setDigits( String digits ) {
        this.digits = digits;
    }
    
    public String getAudioUrl() {
        return audioUrl;
    }
    
    public void setAudioUrl( String audioUrl ) {
        this.audioUrl = audioUrl;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus( String status ) {
        this.status = status;
    }
}
