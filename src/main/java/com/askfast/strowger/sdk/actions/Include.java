package com.askfast.strowger.sdk.actions;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "include")
public class Include implements Action {

    private URI location;
    
    public Include() {}
    
    public Include(URI location) {
        this.location = location;
    }
    
    public URI getLocation() {
        return location;
    }
    
    public void setLocation( URI location ) {
        this.location = location;
    }
}
