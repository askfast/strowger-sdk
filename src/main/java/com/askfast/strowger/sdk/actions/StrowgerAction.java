package com.askfast.strowger.sdk.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.askfast.strowger.sdk.model.StrowgerBase;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StrowgerAction extends StrowgerBase {

    private List<Action> data;
    
    public static StrowgerAction fromJson(String json) {
        ObjectMapper om = new ObjectMapper();
        StrowgerAction action = null;
        try {
            action = om.readValue( json, StrowgerAction.class );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return action;
    }
    
    public StrowgerAction() {
        super();
        data = new ArrayList<>();
    }
    
    public void addAction( Action action ) {
        this.data.add( action );
    }
    
    public List<Action> getData() {
        return data;
    }
}
