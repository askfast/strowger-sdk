package com.askfast.strowger.sdk.model;


public class Peer {
    
    private String peer;
    private StatusCallback statusCallback;
    
    public Peer (String peer, StatusCallback statusCallback) {
        this.peer = peer;
        this.statusCallback = statusCallback;
    }
    
    public String getPeer() {
        return peer;
    }
    
    public void setPeer( String peer, StatusCallback callback ) {
        this.peer = peer;
    }
    
    public StatusCallback getStatusCallback() {
        return statusCallback;
    }
    
    public void setStatusCallback( StatusCallback statusCallback ) {
        this.statusCallback = statusCallback;
    }
}
