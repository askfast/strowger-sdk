package com.askfast.strowger.sdk.actions;
import java.net.URI;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import com.askfast.strowger.sdk.actions.Play;
import com.askfast.strowger.sdk.actions.StrowgerAction;


public class StrowgerActionTest{
    
    @Test
    public void play() {
        
        StrowgerAction action = new StrowgerAction();
        action.addAction( new Play(Arrays.asList(URI.create("http://test.wav"))) );
        
        Assert.assertEquals( "{\"status\":0,\"version\":\"1.0\",\"msg\":\"\",\"data\":[{\"play\":{\"locations\":[\"http://test.wav\"]}}]}", action.toJson() );
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
        Play play = new Play(Arrays.asList(URI.create("http://test.wav")));
        action.addAction( new Dtmf(URI.create("http://askfast.answer"), 5, "#", 10, play) );
        
        Assert.assertEquals( "{\"status\":0,\"version\":\"1.0\",\"msg\":\"\",\"data\":[{\"dtmf\":{\"url\":\"http://askfast.answer\",\"timeout\":5,\"finishOnKey\":\"#\",\"maxDigits\":10,\"play\":{\"locations\":[\"http://test.wav\"]}}}]}", action.toJson() );
    }
}
