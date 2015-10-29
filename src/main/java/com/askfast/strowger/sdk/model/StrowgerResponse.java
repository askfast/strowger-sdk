package com.askfast.strowger.sdk.model;

public class StrowgerResponse<T> extends StrowgerBase {

    private T data;
    
    public StrowgerResponse() {
        super();
    }
    
    public StrowgerResponse(T data) {
        super();
        this.data = data;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData( T data ) {
        this.data = data;
    }
}
