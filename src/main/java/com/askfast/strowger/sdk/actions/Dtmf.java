package com.askfast.strowger.sdk.actions;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "dtmf")
public class Dtmf implements Action {

    private URI url;
    private Integer timeout;
    private String finishOnKey;
    private Integer maxDigits;
    private Play play;
    
    public Dtmf() {}
    
    public Dtmf(URI url, Integer timeout, String finishOnKey, Integer maxDigits, Play play) {
        this.url = url;
        this.timeout = timeout;
        this.finishOnKey = finishOnKey;
        this.maxDigits = maxDigits;
        this.play = play;
    }
    
    public URI getUrl() {
        return url;
    }
    
    public void setUrl( URI url ) {
        this.url = url;
    }
    
    public Integer getTimeout() {
        return timeout;
    }
    
    public void setTimeout( Integer timeout ) {
        this.timeout = timeout;
    }
    
    public String getFinishOnKey() {
        return finishOnKey;
    }
    
    public void setFinishOnKey( String finishOnKey ) {
        this.finishOnKey = finishOnKey;
    }
    
    public Integer getMaxDigits() {
        return maxDigits;
    }
    
    public void setMaxDigits( Integer maxDigits ) {
        this.maxDigits = maxDigits;
    }
    
    @JsonTypeInfo(use=JsonTypeInfo.Id.NONE)
    public Play getPlay() {
        return play;
    }
    
    
    public void setPlay(Play play) {
        this.play = play;
    }
}
