package com.askfast.strowger.sdk.actions;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Plays an audio from a remote url. The command will block execution until the sound is finished playing.
 *
 */
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

    /**
     * Sets location of the audio file
     * @param url location of the audio file
     */
    public void setLocation( URI location ) {
        this.location = location;
    }
}
