package com.askfast.strowger.sdk.actions;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "record")
public class Record implements Action {

    private URI url;
    private String finishOnKey;
    private Integer maxLength;
    private Boolean playSignal;
    
    public Record() {}
    
    public URI getUrl() {
        return url;
    }
    
    public void setUrl( URI url ) {
        this.url = url;
    }
    
    public String getFinishOnKey() {
        return finishOnKey;
    }
    
    public void setFinishOnKey( String finishOnKey ) {
        this.finishOnKey = finishOnKey;
    }
    
    public Integer getMaxLength() {
        return maxLength;
    }
    
    public void setMaxLength( Integer maxLength ) {
        this.maxLength = maxLength;
    }
    
    public Boolean getPlaySignal() {
        return playSignal;
    }
    
    public void setPlaySignal( Boolean playSignal ) {
        this.playSignal = playSignal;
    }
}
