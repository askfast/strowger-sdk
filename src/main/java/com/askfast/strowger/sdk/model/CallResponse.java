package com.askfast.strowger.sdk.model;

import java.util.Map;

public class CallResponse {

    private Map<String, String> headers;
    private String statusCode;
    private String statusMessage;
    private String body;
    
    public CallResponse() {}
    
    public Map<String, String> getHeaders() {
        return headers;
    }
    
    public void setHeaders( Map<String, String> headers ) {
        this.headers = headers;
    }
    
    public String getStatusCode() {
        return statusCode;
    }
    
    public void setStatusCode( String statusCode ) {
        this.statusCode = statusCode;
    }
    
    public String getStatusMessage() {
        return statusMessage;
    }
    
    public void setStatusMessage( String statusMessage ) {
        this.statusMessage = statusMessage;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody( String body ) {
        this.body = body;
    }
}
