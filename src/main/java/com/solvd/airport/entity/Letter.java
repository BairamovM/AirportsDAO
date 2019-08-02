package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class Letter {

    private static final Logger logEntity = Logger.getLogger(Letter.class);

    private Long id;
    private String sender;
    private String receiver;
    private String senderAddress;
    private String receiverAddress;
    private Long weight;
    private Departure departure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        try {
            if (id <= 0) {
                logEntity.error("Value id error = " + id);
                throw new EntityException("Value id error = " + id);
            } else if (id >= 1) {
                this.id = id;
            }
        } catch (EntityException e) {
            logEntity.error("Value id error = " + id);
        }
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {

        try {
            if (sender == null) {
                logEntity.error("Value sender NULL error = " + sender);
                throw new EntityException("Value sender NULL error = " + sender);
            } else if (sender != null) {
                this.sender = sender;
            }
        } catch (EntityException e) {
            logEntity.error("Value sender NULL error = " + sender);
        }
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {

        try {
            if (receiver == null) {
                logEntity.error("Value receiver NULL error = " + receiver);
                throw new EntityException("Value receiver NULL error = " + receiver);
            } else if (receiver != null) {
                this.receiver = receiver;
            }
        } catch (EntityException e) {
            logEntity.error("Value receiver NULL error = " + receiver);
        }
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {

        try {
            if (senderAddress == null) {
                logEntity.error("Value senderAddress NULL error = " + senderAddress);
                throw new EntityException("Value senderAddress NULL error = " + senderAddress);
            } else if (senderAddress != null) {
                this.senderAddress = senderAddress;
            }
        } catch (EntityException e) {
            logEntity.error("Value senderAddress NULL error = " + senderAddress);
        }
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {

        try {
            if (receiverAddress == null) {
                logEntity.error("Value receiverAddress NULL error = " + receiverAddress);
                throw new EntityException("Value receiverAddress NULL error = " + receiverAddress);
            } else if (receiverAddress != null) {
                this.receiverAddress = receiverAddress;
            }
        } catch (EntityException e) {
            logEntity.error("Value receiverAddress NULL error = " + receiverAddress);
        }
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {

        try {
            if (weight <= 0) {
                logEntity.error("Value weight error = " + weight);
                throw new EntityException("Value weight error = " + weight);
            } else if (weight >= 1) {
                this.weight = weight;
            }
        } catch (EntityException e) {
            logEntity.error("Value weight error = " + weight);
        }
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }
}
