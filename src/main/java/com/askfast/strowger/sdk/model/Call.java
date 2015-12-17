package com.askfast.strowger.sdk.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Call {

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

    private String callId;
    private String caller;
    private String called;
    private String callType;
    private Date dialTime;
    private Date connectTime;
    private Date terminationTime;
    private String completionReason;
    private DtmfFinishReason dtmfFinishReason;

    public Call() {
    }

    public String getCallId() {

        return callId;
    }

    public void setCallId(String callId) {

        this.callId = callId;
    }

    public String getCaller() {

        return caller;
    }

    public void setCaller(String caller) {

        this.caller = caller;
    }

    public String getCalled() {

        return called;
    }

    public void setCalled(String called) {

        this.called = called;
    }

    public String getCallType() {

        return callType;
    }

    public void setCallType(String callType) {

        this.callType = callType;
    }

    public Date getDialTime() {

        return dialTime;
    }

    public void setDialTime(Date dialTime) {

        this.dialTime = dialTime;
    }

    public Date getConnectTime() {

        return connectTime;
    }

    public void setConnectTime(Date connectTime) {

        this.connectTime = connectTime;
    }

    public Date getTerminationTime() {

        return terminationTime;
    }

    public void setTerminationTime(Date terminationTime) {

        this.terminationTime = terminationTime;
    }

    public String getCompletionReason() {

        return completionReason;
    }

    public void setCompletionReason(String completionReason) {

        this.completionReason = completionReason;
    }

    public DtmfFinishReason getDtmfFinishReason() {

        return dtmfFinishReason;
    }

    public void setDtmfFinishReason(DtmfFinishReason dtmfFinishReason) {

        this.dtmfFinishReason = dtmfFinishReason;
    }
}
