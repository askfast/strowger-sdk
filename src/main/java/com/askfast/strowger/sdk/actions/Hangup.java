package com.askfast.strowger.sdk.actions;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "hangup")
public class Hangup implements Action {
    public Hangup() {}
}
