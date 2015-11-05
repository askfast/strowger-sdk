package com.askfast.strowger.sdk.model;

import com.askfast.strowger.util.JOM;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StrowgerBase {

    protected Integer status;
    protected String version;
    protected String msg;
    
    
    public StrowgerBase() {
        status = 0;
        version = "1.0";
        msg = "";
    }
    
    /**
     * Status indicates whether the request was successful or not. A value of zero means success, any other value will be considered an error.
     * @return status code of the strowger request
     */
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus( Integer status ) {
        this.status = status;
    }
    
    /**
     * Version sets the version format for the response and commands.
     * @return version of the strowger api
     */
    public String getVersion() {
        return version;
    }
    
    public void setVersion( String version ) {
        this.version = version;
    }
    
    /**
     * a contextual message for the response. This message will not be interpreted in any way, but logged straight into the call request log.
     * @return error message of strowger request
     */
    public String getMsg() {
        return msg;
    }
    
    public void setMsg( String msg ) {
        this.msg = msg;
    }
    
    @JsonIgnore
    public String toJson() {
        ObjectMapper om = JOM.getInstance();
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
