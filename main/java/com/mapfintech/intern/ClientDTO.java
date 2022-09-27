package com.mapfintech.intern;

import java.util.Date;

public class ClientDTO {
    /**
     * Fields
     */
    private long clientId;
    private String clientUserName;
    private String clientName;
    private String clientSurname;
    private String clientCompany;
    private String clientLEI;
    private String clientEmail;
    private long clientPhone;
    private String clientDemoFlag;
    private String clientStatus;
    private Date clientDateCreated;
    private Date clientDateUpdated;
    private int clientUserCreated;
    private int clientUserUpdated;

    /**
     * setters,getters
     */
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getClientLEI() {
        return clientLEI;
    }

    public void setClientLEI(String clientLEI) {
        this.clientLEI = clientLEI;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public long getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(long clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientDemoFlag() {
        return clientDemoFlag;
    }

    public void setClientDemoFlag(String clientDemoFlag) {
        this.clientDemoFlag = clientDemoFlag;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Date getClientDateCreated() {
        return clientDateCreated;
    }

    public void setClientDateCreated(Date clientDateCreated) {
        this.clientDateCreated = clientDateCreated;
    }

    public Date getClientDateUpdated() {
        return clientDateUpdated;
    }

    public void setClientDateUpdated(Date clientDateUpdated) {
        this.clientDateUpdated = clientDateUpdated;
    }

    public int getClientUserCreated() {
        return clientUserCreated;
    }

    public void setClientUserCreated(int clientUserCreated) {
        this.clientUserCreated = clientUserCreated;
    }

    public int getClientUserUpdated() {
        return clientUserUpdated;
    }

    public void setClientUserUpdated(int clientUserUpdated) {
        this.clientUserUpdated = clientUserUpdated;
    }
}
