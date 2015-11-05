package com.askfast.strowger.sdk.model;

import java.net.URI;
import java.util.Map;

public class CallRequest {

    private URI url;
    private Map<String, String> headers;
    private String body;
    private String verb;
    private Integer timeout;
    
    public CallRequest() {}
    
    public URI getUrl() {
        return url;
    }
    
    public void setUrl( URI url ) {
        this.url = url;
    }
    
    public Map<String, String> getHeaders() {
        return headers;
    }
    
    public void setHeaders( Map<String, String> headers ) {
        this.headers = headers;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody( String body ) {
        this.body = body;
    }
    
    public String getVerb() {
        return verb;
    }
    
    public void setVerb( String verb ) {
        this.verb = verb;
    }
    
    public Integer getTimeout() {
        return timeout;
    }
    
    public void setTimeout( Integer timeout ) {
        this.timeout = timeout;
    }
}
