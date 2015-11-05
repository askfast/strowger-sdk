package com.askfast.strowger.sdk.actions;
import java.net.URI;

import org.junit.Assert;
import org.junit.Test;

import com.askfast.strowger.sdk.actions.Play;
import com.askfast.strowger.sdk.actions.StrowgerAction;


public class StrowgerActionTest{
    
    @Test
    public void play() {
        
        StrowgerAction action = new StrowgerAction();
        action.addAction( new Play(URI.create("http://test.wav")) );
        
        Assert.assertEquals( "{\"status\":0,\"version\":\"1.0\",\"msg\":\"\",\"data\":[{\"play\":{\"location\":\"http://test.wav\"}}]}", action.toJson() );
    }
    
    @Test
    public void hangup() {
        
        StrowgerAction action = new StrowgerAction();
        action.addAction( new Hangup() );
        
        Assert.assertEquals( "{\"status\":0,\"version\":\"1.0\",\"msg\":\"\",\"data\":[{\"hangup\":{}}]}", action.toJson() );
    }
    
    @Test
    public void dtmf() {
        
        StrowgerAction action = new StrowgerAction();
        action.addAction( new Dtmf() );
        
        Assert.assertEquals( "{\"status\":0,\"version\":\"1.0\",\"msg\":\"\",\"data\":[{\"dtmf\":{}}]}", action.toJson() );
        
        action = new StrowgerAction();
        action.addAction( new Dtmf(URI.create("http://test.wav"), 5, "#", 10) );
        
        Assert.assertEquals( "{\"status\":0,\"version\":\"1.0\",\"msg\":\"\",\"data\":[{\"dtmf\":{\"url\":\"http://test.wav\",\"timeout\":5,\"finishOnKey\":\"#\",\"maxDigits\":10}}]}", action.toJson() );
    }
}
