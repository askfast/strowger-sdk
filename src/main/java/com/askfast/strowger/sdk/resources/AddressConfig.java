package com.askfast.strowger.sdk.resources;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
@JsonTypeName(value = "config")
public class AddressConfig {

    private URI controlUrl;
    private URI fallbackControlUrl;
    private Integer timeout;
    
    public AddressConfig(URI controlUrl, URI fallbackControlUrl, Integer timeout) {
        this.controlUrl = controlUrl;
        this.fallbackControlUrl = fallbackControlUrl;
        this.timeout = timeout;
    }
    
    public URI getControlUrl() {
        return controlUrl;
    }
    
    public void setControlUrl( URI controlUrl ) {
        this.controlUrl = controlUrl;
    }
    
    public URI getFallbackControlUrl() {
        return fallbackControlUrl;
    }
    
    public void setFallbackControlUrl( URI fallbackControlUrl ) {
        this.fallbackControlUrl = fallbackControlUrl;
    }
    
    public Integer getTimeout() {
        return timeout;
    }
    
    public void setTimeout( Integer timeout ) {
        this.timeout = timeout;
    }
}
