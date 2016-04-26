package com.askfast.strowger.sdk.model;

import java.util.Collection;
import java.util.Date;

/**
 * This is the Peer information that is returned by Strowger on a status
 * information of a referral action
 * 
 * @author shravanshetty
 *
 */
public class DialedPeer {
    
    private Collection<String> dialedPeers;
    private String connectedPeer;
    private Date dialTime;
    private Date connectTime;
    private Date terminationTime;
    private String channelHost;
    private String channelId;
    
    public DialedPeer() {
    }
    
    public Collection<String> getDialedPeers() {
    
        return dialedPeers;
    }
    
    public void setDialedPeers(Collection<String> dialedPeers) {
    
        this.dialedPeers = dialedPeers;
    }
    
    public String getConnectedPeer() {
    
        return connectedPeer;
    }
    
    public void setConnectedPeer(String connectedPeer) {
    
        this.connectedPeer = connectedPeer;
    }
    
    public Date getDialTime() {
    
        return dialTime;
    }
    
    public void setDialTime(Date dialTime) {
    
        this.dialTime = dialTime;
    }
    
    public Date getConnectTime() {
    
        return connectTime;
    }
    
    public void setConnectTime(Date connectTime) {
    
        this.connectTime = connectTime;
    }
    
    public Date getTerminationTime() {
    
        return terminationTime;
    }
    
    public void setTerminationTime(Date terminationTime) {
    
        this.terminationTime = terminationTime;
    }
    
    public String getChannelHost() {
    
        return channelHost;
    }
    
    public void setChannelHost(String channelHost) {
    
        this.channelHost = channelHost;
    }
    
    public String getChannelId() {
    
        return channelId;
    }

    public void setChannelId(String channelId) {
    
        this.channelId = channelId;
    }
}