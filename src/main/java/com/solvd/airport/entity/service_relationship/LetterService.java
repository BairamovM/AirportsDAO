package com.solvd.airport.entity.service_relationship;

import org.apache.log4j.Logger;

public class LetterService {

    private static final Logger logEntity = Logger.getLogger(LetterService.class);

    private Long id;
    private String sender;
    private String receiver;
    private String senderAddress;
    private String receiverAddress;
    private Long weight;
    private DepartureService departureService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public DepartureService getDepartureService() {
        return departureService;
    }

    public void setDepartureService(DepartureService departureService) {
        this.departureService = departureService;
    }
}
