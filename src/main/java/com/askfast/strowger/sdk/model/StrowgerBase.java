package com.askfast.strowger.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StrowgerBase {
    
    protected static ObjectMapper om = null;

    protected Integer status;
    protected Integer version;
    protected String msg;
    
    
    public StrowgerBase() {
        status = 0;
        version = 1;
        msg = "";
    }
    
    public Integer getStatus() {
        return status;
    }
    
    /**
     * Status indicates whether the request was successful or not. A value of zero means success, any other value will be considered an error.
     * @param status
     */
    public void setStatus( Integer status ) {
        this.status = status;
    }
    
    public Integer getVersion() {
        return version;
    }
    
    /**
     * Version sets the version format for the response and commands.
     * @param version
     */
    public void setVersion( Integer version ) {
        this.version = version;
    }
    
    public String getMsg() {
        return msg;
    }
    
    /**
     * a contextual message for the response. This message will not be interpreted in any way, but logged straight into the call request log.
     * @param msg
     */
    public void setMsg( String msg ) {
        this.msg = msg;
    }
    
    @JsonIgnore
    public String toJson() {
        if(om == null) {
          om = new ObjectMapper();
          om.setSerializationInclusion(Include.NON_NULL);
        }
        String result = null;
        try {
            result = om.writeValueAsString( this );
        }
        catch ( JsonProcessingException e ) {
            e.printStackTrace();
        }
        return result;
    }
}
