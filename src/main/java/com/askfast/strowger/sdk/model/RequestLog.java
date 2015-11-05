package com.askfast.strowger.sdk.model;

import java.util.Date;

public class RequestLog {

    private String callId;
    private CallRequest request;
    private CallResponse response;
    private String processResult;
    private Date requestTime;
    private Date responseTime;
    private Integer duration;
    
    public RequestLog() {}
    
    public String getCallId() {
        return callId;
    }
    
    public void setCallId( String callId ) {
        this.callId = callId;
    }
    
    public CallRequest getRequest() {
        return request;
    }
    
    public void setRequest( CallRequest request ) {
        this.request = request;
    }
    
    public CallResponse getResponse() {
        return response;
    }
    
    public void setResponse( CallResponse response ) {
        this.response = response;
    }
    
    public String getProcessResult() {
        return processResult;
    }
    
    public void setProcessResult( String processResult ) {
        this.processResult = processResult;
    }
    
    public Date getRequestTime() {
        return requestTime;
    }
    
    public void setRequestTime( Date requestTime ) {
        this.requestTime = requestTime;
    }
    
    public Date getResponseTime() {
        return responseTime;
    }
    
    public void setResponseTime( Date responseTime ) {
        this.responseTime = responseTime;
    }
    
    public Integer getDuration() {
        return duration;
    }
    
    public void setDuration( Integer duration ) {
        this.duration = duration;
    }
}
