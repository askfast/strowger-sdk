package com.askfast.strowger.sdk.actions;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "play")
public class Play implements Action {

    private URI location;
    
    public Play() {}
    
    public Play(URI location) {
        this.location = location;
    }
    
    public URI getLocation() {
        return location;
    }
    
    public void setLocation( URI location ) {
        this.location = location;
    }
}
