package com.askfast.strowger.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DtmfFinishReason {

    /**
     * Means that the max length of the dtmf capture was reached
     */
    MAX_DIGITS("maxDigits"), 
    /**
     * Means that the termination key was pressed by the caller
     */
    FINISH_KEY("finishKey"),
    /**
     * The caller hanged up the call
     */
    HANGUP("hangup"),
    /**
     * The timeout was reached
     */
    TIMEOUT("timeout");

    private String name;

    private DtmfFinishReason(String name) {
        this.name = name;
    }

    @JsonCreator
    public static DtmfFinishReason fromJson(String name) {

        for (DtmfFinishReason reason : values()) {
            if (reason.toString().equalsIgnoreCase(name) || reason.name.equalsIgnoreCase(name)) {
                return reason;
            }
        }
        return null;
    }
}
