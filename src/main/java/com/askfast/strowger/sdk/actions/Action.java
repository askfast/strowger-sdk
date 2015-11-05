package com.askfast.strowger.sdk.actions;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Action is the interface class for all the strowger api actions
 *
 */
@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME, property="type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Decline.class, name = "decline"),
    @JsonSubTypes.Type(value = Dial.class, name = "dial"),
    @JsonSubTypes.Type(value = Dtmf.class, name = "dtmf"),
    @JsonSubTypes.Type(value = Hangup.class, name = "hangup"),
    @JsonSubTypes.Type(value = Include.class, name = "include"),
    @JsonSubTypes.Type(value = Play.class, name = "play"),
    @JsonSubTypes.Type(value = Record.class, name = "record")})
public interface Action {}
