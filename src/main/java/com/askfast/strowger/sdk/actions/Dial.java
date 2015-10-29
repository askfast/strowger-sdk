package com.askfast.strowger.sdk.actions;

import java.net.URI;
import java.util.List;

import com.askfast.strowger.sdk.model.Peer;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "dial")
public class Dial implements Action {

    private List<Peer> peers;
    private String sendKeys;
    private URI preConnectUrl;
    private Integer ringTimeout;
    private Integer callTimeout;
    private String callerId;
    private String record;
    private URI  completionUrl;
    private Boolean finishOnStar;
    
    public Dial() {}
    
    public List<Peer> getPeers() {
        return peers;
    }
    
    public void addPeer(Peer peer) {
        peers.add(peer);
    }
    
    public void setPeers( List<Peer> peers ) {
        this.peers = peers;
    }
    
    public String getSendKeys() {
        return sendKeys;
    }
    
    public void setSendKeys( String sendKeys ) {
        this.sendKeys = sendKeys;
    }
    
    public URI getPreConnectUrl() {
        return preConnectUrl;
    }
    
    public void setPreConnectUrl( URI preConnectUrl ) {
        this.preConnectUrl = preConnectUrl;
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
    
    public URI getCompletionUrl() {
        return completionUrl;
    }
    
    public void setCompletionUrl( URI completionUrl ) {
        this.completionUrl = completionUrl;
    }
    
    public Boolean getFinishOnStar() {
        return finishOnStar;
    }
    
    public void setFinishOnStar( Boolean finishOnStar ) {
        this.finishOnStar = finishOnStar;
    }
}
