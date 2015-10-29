package com.askfast.strowger.sdk.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class StatusCallback {

    private URI url;
    private List<String> events;
    
    public StatusCallback(URI url) {
        this.url = url;
    }
    
    public URI getUrl() {
        return url;
    }
    
    public void setUrl( URI url ) {
        this.url = url;
        this.events = new ArrayList<>();
    }
    
    public List<String> getEvents() {
        return events;
    }
    
    public void addEvent(String event) {
        this.events.add(event);
    }
    
    public void setEvents( List<String> events ) {
        this.events = events;
    }
}
