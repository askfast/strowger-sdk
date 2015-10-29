package com.askfast.strowger.sdk.actions;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "decline")
public class Decline implements Action {
    
    private String reason;
    
    public Decline() {}
    
    public Decline(String reason) {
        this.reason = reason;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason( String reason ) {
        this.reason = reason;
    }
}
