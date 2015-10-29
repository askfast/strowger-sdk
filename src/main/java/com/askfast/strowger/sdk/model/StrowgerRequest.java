package com.askfast.strowger.sdk.model;

import java.io.IOException;

import com.askfast.strowger.sdk.resources.Call;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StrowgerRequest extends StrowgerBase {

    private Call data;
    
    public StrowgerRequest() {
        super();
    }
    
    public static StrowgerRequest fromJson(String json) {
        ObjectMapper om = new ObjectMapper();
        StrowgerRequest request = null;
        try {
            request = om.readValue( json, StrowgerRequest.class );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return request;
    }
    
    public StrowgerRequest(Call data) {
        super();
        this.data = data;
    }
    
    public Call getData() {
        return data;
    }
    
    public void setData( Call data ) {
        this.data = data;
    }
}
