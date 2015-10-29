package com.askfast.strowger.sdk.model;


public class Peer {
    
    private String peer;
    private StatusCallback statusCallback;
    
    public Peer (String peer) {
        this.peer = peer;
    }
    
    public String getPeer() {
        return peer;
    }
    
    public void setPeer( String peer ) {
        this.peer = peer;
    }
    
    public StatusCallback getStatusCallback() {
        return statusCallback;
    }
    
    public void setStatusCallback( StatusCallback statusCallback ) {
        this.statusCallback = statusCallback;
    }
}
