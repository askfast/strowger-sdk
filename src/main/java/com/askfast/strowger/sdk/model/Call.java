package com.askfast.strowger.sdk.model;

import java.util.Collection;
import java.util.Date;

public class Call {

    private String callId;
    private String caller;
    private String called;
    private String callType;
    private Date dialTime;
    private Date connectTime;
    private Date terminationTime;
    private Collection<DialedPeer> dialedPeers;
    private String originName;
    private String originCallId;
    private String originAddress;
    private String tenantId;
    private String serviceId;
    private String endpointAddress;
    private String disposition;

    public Call() {
    }

    /**
     * Specific callid for this instance
     * @return String callid
     */
    public String getCallId() {

        return callId;
    }

    public void setCallId(String callId) {

        this.callId = callId;
    }

    /**
     * The caller
     * @return String caller
     */
    public String getCaller() {

        return caller;
    }

    public void setCaller(String caller) {

        this.caller = caller;
    }

    /**
     * The address of the person called
     * @return String address
     */
    public String getCalled() {

        return called;
    }

    public void setCalled(String called) {

        this.called = called;
    }

    /**
     * The direction of the call
     * @return Returns either outgoing or incoming
     */
    public String getCallType() {

        return callType;
    }

    public void setCallType(String callType) {

        this.callType = callType;
    }

    /**
     * The timestamp of the request made
     * @return TimeStamp in the format yyyy-mm-ddThh:mm:ss.mssZ format (US timezone)
     */
    public Date getDialTime() {

        return dialTime;
    }

    public void setDialTime(Date dialTime) {

        this.dialTime = dialTime;
    }

    /**
     * The timestamp of the actual call connection made
     * @return TimeStamp in the format yyyy-mm-ddThh:mm:ss.mssZ format (US timezone)
     */
    public Date getConnectTime() {

        return connectTime;
    }

    public void setConnectTime(Date connectTime) {

        this.connectTime = connectTime;
    }

    /**
     * The timestamp of when the call is terminated
     * @return TimeStamp in the format yyyy-mm-ddThh:mm:ss.mssZ format (US timezone)
     */

    public Date getTerminationTime() {

        return terminationTime;
    }

    public void setTerminationTime(Date terminationTime) {

        this.terminationTime = terminationTime;
    }

    /**
     * The addresses that are dialed in.
     * @return Collection of all {@link Peer}
     */
    public Collection<DialedPeer> getDialedPeers() {

        return dialedPeers;
    }

    public void setDialedPeers(Collection<DialedPeer> dialedPeers) {

        this.dialedPeers = dialedPeers;
    }

    /**
     * Unique callId that is the parent of this id.
     * @return String callId of the parent
     */
    public String getOriginCallId() {
    
        return originCallId;
    }

    
    public void setOriginCallId(String originCallId) {
    
        this.originCallId = originCallId;
    }

    /**
     * IP address of the call requester
     * @return
     */
    public String getOriginAddress() {
    
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
    
        this.originAddress = originAddress;
    }

    /**
     * The customer id, in case of multiple accounts.
     * @return String tenantid
     */
    public String getTenantId() {
    
        return tenantId;
    }
    
    public void setTenantId(String tenantId) {
    
        this.tenantId = tenantId;
    }

    /**
     * The carrierid that is used to perform this call
     * @return String of carrierid
     */
    public String getServiceId() {
    
        return serviceId;
    }
    
    public void setServiceId(String serviceId) {
    
        this.serviceId = serviceId;
    }
    
    /**
     * the adapter address used to perform the sequence of actions
     * @return String adapter myAddress
     */
    public String getEndpointAddress() {
    
        return endpointAddress;
    }
    
    public void setEndpointAddress(String endpointAddress) {
    
        this.endpointAddress = endpointAddress;
    }
    
    /**
     * Call status
     * @return String status of the call
     */
    public String getDisposition() {
    
        return disposition;
    }
    
    public void setDisposition(String disposition) {
    
        this.disposition = disposition;
    }

    public String getOriginName() {

        return originName;
    }

    public void setOriginName(String originName) {

        this.originName = originName;
    }
}
