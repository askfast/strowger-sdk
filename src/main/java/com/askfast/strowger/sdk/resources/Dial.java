package com.askfast.strowger.sdk.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.askfast.strowger.sdk.model.Peer;

public class Dial{

    private List<Peer> peers;
    private URI controlUrl;
    private URI controlFallbackUrl;
    private URI completionUrl;
    private String sendKeys;
    private Integer ringTimeout;
    private Integer callTimeout;
    private String callerId;
    private String record;
    private Boolean finishOnStar;
    
    public Dial() {
        this.peers = new ArrayList<>();
    }
    
    public List<Peer> getPeers() {
        return peers;
    }
    
    public void addPeer(Peer peer) {
        this.peers.add(peer);
    }
    
    public void setPeers( List<Peer> peers ) {
        this.peers = peers;
    }
    
    public URI getControlUrl() {
        return controlUrl;
    }
    
    public void setControlUrl( URI controlUrl ) {
        this.controlUrl = controlUrl;
    }
    
    public URI getControlFallbackUrl() {
        return controlFallbackUrl;
    }
    
    public void setControlFallbackUrl( URI controlFallbackUrl ) {
        this.controlFallbackUrl = controlFallbackUrl;
    }
    
    public URI getCompletionUrl() {
        return completionUrl;
    }
    
    public void setCompletionUrl( URI completionUrl ) {
        this.completionUrl = completionUrl;
    }
    
    public String getSendKeys() {
        return sendKeys;
    }
    
    public void setSendKeys( String sendKeys ) {
        this.sendKeys = sendKeys;
    }
    
    public Integer getRingTimeout() {
        return ringTimeout;
    }
    
    public void setRingTimeout( Integer ringTimeout ) {
        this.ringTimeout = ringTimeout;
    }
    
    public Integer getCallTimeout() {
        return callTimeout;
    }
    
    public void setCallTimeout( Integer callTimeout ) {
        this.callTimeout = callTimeout;
    }
    
    public String getCallerId() {
        return callerId;
    }
    
    public void setCallerId( String callerId ) {
        this.callerId = callerId;
    }
    
    public String getRecord() {
        return record;
    }
    
    public void setRecord( String record ) {
        this.record = record;
    }
    
    public Boolean getFinishOnStar() {
        return finishOnStar;
    }
    
    public void setFinishOnStar( Boolean finishOnStar ) {
        this.finishOnStar = finishOnStar;
    }
}
