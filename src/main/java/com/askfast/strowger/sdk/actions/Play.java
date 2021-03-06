package com.askfast.strowger.sdk.actions;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Plays an audio from a remote url. The command will block execution until the sound is finished playing.
 *
 */
@JsonTypeName(value = "play")
public class Play implements Action {

    private List<URI> locations;
    private String location;
    
    public Play() {}
    
    public Play(List<URI> locations) {
        this.locations = locations;
    }
    
    public Play(String location) {
        this.setLocation(location);
    }

    public List<URI> getLocations() {
        return locations;
    }

    /**
     * Sets location of the audio file
     * @param locations Array of urls that can be played
     */
    public void setLocations( List<URI> locations ) {
        this.locations = locations;
    }
    
    /**
     * Add a single url to the list of audio to be played
     * @param location Location to be added.
     */
    public void addLocation(URI location) {
        if(this.locations == null) {
            this.locations = new ArrayList<>();
        }
        
        this.locations.add(location);
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }
}
