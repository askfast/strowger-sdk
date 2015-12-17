package com.askfast.strowger.sdk.actions;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import com.askfast.strowger.sdk.model.Peer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "dial")
public class Dial implements Action {

    private List<Peer> peers;
    private String sendKeys;
    private URI preConnectUrl;
    private Integer ringTimeout;
    private Integer callTimeout;
    private String callerId;
    private CallRecord record;
    private URI completionUrl;
    private Boolean finishOnStar;

    public enum CallRecord {

            NO, FULL, ANSWER;

        @JsonCreator
        public static CallRecord fromJson(String name) {

            for (CallRecord recordOption : values()) {
                if (recordOption.toString().equalsIgnoreCase(name)) {
                    return recordOption;
                }
            }
            return null;
        }
    }

    public Dial() {
    }

    /**
     * Adds no status events, preConnectUrl or completionUrl
     * @param caller The address of the member who is calling
     * @param called The address of the member is being called
     */
    public Dial(String caller, String called) {
        
        this.callerId = caller;
        addPeer(new Peer(called, null));
    }
    
    /**
     * Simple consturctor with options
     * @param callerId This address will be displayed as the callerId
     * @param sendKeys Any pre-determined keys will be sent to this number when picked up
     * @param preConnectUrl Strowger performs this action based on the request received from this url
     * @param completionUrl Strowger sends the termination information to this endpoint
     * @param ringTimeout The time in seconds that it waits after ringing. 
     * @param callTimeout The time in seconds that it waits after calling. 
     * @param record Options of recording a call. 
     * @param finishOnStar If strowger must end a call on entry of these keys in the same sequence
     */
    public Dial(String callerId, String sendKeys, URI preConnectUrl, URI completionUrl, Integer ringTimeout,
        Integer callTimeout, CallRecord record, Boolean finishOnStar) {

        this.callerId = callerId;
        this.sendKeys = sendKeys;
        this.preConnectUrl = preConnectUrl;
        this.completionUrl = completionUrl;
        this.ringTimeout = ringTimeout;
        this.callTimeout = callTimeout;
        this.record = record != null ? record : CallRecord.NO;
        this.finishOnStar = finishOnStar;
    }

    public List<Peer> getPeers() {

        return peers;
    }

    public void addPeer(Peer peer) {

        if (peer != null) {
            peers = peers != null ? peers : new ArrayList<Peer>();
            peers.add(peer);
        }
    }

    public void setPeers(List<Peer> peers) {

        this.peers = peers;
    }

    public String getSendKeys() {

        return sendKeys;
    }

    public void setSendKeys(String sendKeys) {

        this.sendKeys = sendKeys;
    }

    public URI getPreConnectUrl() {

        return preConnectUrl;
    }

    public void setPreConnectUrl(URI preConnectUrl) {

        this.preConnectUrl = preConnectUrl;
    }

    public Integer getRingTimeout() {

        return ringTimeout;
    }

    public void setRingTimeout(Integer ringTimeout) {

        this.ringTimeout = ringTimeout;
    }

    public Integer getCallTimeout() {

        return callTimeout;
    }

    public void setCallTimeout(Integer callTimeout) {

        this.callTimeout = callTimeout;
    }

    public String getCallerId() {

        return callerId;
    }

    public void setCallerId(String callerId) {

        this.callerId = callerId;
    }

    public String getRecord() {

        return record != null ? record.toString().toLowerCase() : null;
    }

    public void setRecord(CallRecord record) {

        this.record = record;
    }

    public URI getCompletionUrl() {

        return completionUrl;
    }

    public void setCompletionUrl(URI completionUrl) {

        this.completionUrl = completionUrl;
    }

    public Boolean getFinishOnStar() {

        return finishOnStar;
    }

    public void setFinishOnStar(Boolean finishOnStar) {

        this.finishOnStar = finishOnStar;
    }
}
