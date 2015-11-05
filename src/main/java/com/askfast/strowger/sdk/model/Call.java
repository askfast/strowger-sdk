package com.askfast.strowger.sdk.model;

import java.util.Date;

public class Call{

    private String callId;
    private String caller;
    private String called;
    private String callType;
    private Date dialTime;
    private Date connectTime;
    private Date terminationTime;
    
    public Call() {}
    
    public String getCallId() {
        return callId;
    }
    
    public void setCallId( String callId ) {
        this.callId = callId;
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

    public String getCallType() {
        return callType;
    }
    
    public void setCallType( String callType ) {
        this.callType = callType;
    }
    
    public Date getDialTime() {
        return dialTime;
    }
    
    public void setDialTime( Date dialTime ) {
        this.dialTime = dialTime;
    }
    
    public Date getConnectTime() {
        return connectTime;
    }
    
    public void setConnectTime( Date connectTime ) {
        this.connectTime = connectTime;
    }
    
    public Date getTerminationTime() {
        return terminationTime;
    }
    
    public void setTerminationTime( Date terminationTime ) {
        this.terminationTime = terminationTime;
    }
}
