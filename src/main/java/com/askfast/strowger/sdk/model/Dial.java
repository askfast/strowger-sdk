package com.askfast.strowger.sdk.model;

import java.net.URI;

public class Dial{

    private String caller;
    private String callerName;
    private String called;
    private URI completionUrl;
    private int timeout;
    private String sendKeys;
    
    public Dial() {}
    
    public Dial(String caller, String called) {
        this(caller, null, called, null, 30);
    }
    
    public Dial(String caller, String callerName, String called) {
        this(caller, callerName, called, null, 30);
    }
    
    public Dial(String caller, String callerName, String called, URI completionUrl, Integer timeout) {
        this.caller = caller;
        this.callerName = callerName;
        this.called = called;
        this.completionUrl = completionUrl;
        this.timeout = timeout;
    }
    
    public String getCaller() {
        return caller;
    }
    
    public void setCaller( String caller ) {
        this.caller = caller;
    }
    
    public String getCallerName() {
        return callerName;
    }
    
    public void setCallerName( String callerName ) {
        this.callerName = callerName;
    }
    
    public String getCalled() {
        return called;
    }
    
    public void setCalled( String called ) {
        this.called = called;
    }
    
    public URI getCompletionUrl() {
        return completionUrl;
    }
    
    public void setCompletionUrl( URI completionUrl ) {
        this.completionUrl = completionUrl;
    }
    
    public int getTimeout() {
        return timeout;
    }
    
    public void setTimeout( int timeout ) {
        this.timeout = timeout;
    }
    
    public String getSendKeys() {
        return sendKeys;
    }
    
    public void setSendKeys( String sendKeys ) {
        this.sendKeys = sendKeys;
    }
}
