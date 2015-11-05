package com.askfast.strowger.sdk.model;

import java.net.URI;

public class AddressConfig {

    private URI controlUrl;
    private URI fallbackControlUrl;
    private URI statusUrl;
    private Integer timeout;
    
    public AddressConfig(URI controlUrl, URI statusUrl) {
        this.controlUrl = controlUrl;
        this.fallbackControlUrl = controlUrl;
        this.statusUrl = statusUrl;
        this.timeout = 30000;
    }
    
    public AddressConfig(URI controlUrl, URI fallbackControlUrl, URI statusUrl, Integer timeout) {
        this.controlUrl = controlUrl;
        this.fallbackControlUrl = fallbackControlUrl;
        this.statusUrl = statusUrl;
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
    
    public URI getStatusUrl() {
        return statusUrl;
    }
    
    public void setStatusUrl( URI statusUrl ) {
        this.statusUrl = statusUrl;
    }
    
    public Integer getTimeout() {
        return timeout;
    }
    
    public void setTimeout( Integer timeout ) {
        this.timeout = timeout;
    }
}
