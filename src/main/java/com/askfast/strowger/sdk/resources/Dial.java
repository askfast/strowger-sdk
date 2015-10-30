package com.askfast.strowger.sdk.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.askfast.strowger.sdk.model.Peer;

public class Dial{

    private List<Peer> peers;
    private URI controlUrl;
    private URI controlFallbackUrl;
    private String sendKeys;
    private Integer timeout;
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
    
    public String getSendKeys() {
        return sendKeys;
    }
    
    public void setSendKeys( String sendKeys ) {
        this.sendKeys = sendKeys;
    }
    
    public Integer getTimeout() {
        return timeout;
    }
    
    public void setTimeout( Integer timeout ) {
        this.timeout = timeout;
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
