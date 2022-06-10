package com.example.santandertechtest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private String instrumentName;
    private double bidPrice;
    private double askPrice;
    private String timestamp;

    public Price(int id, String instrumentName, double bidPrice, double askPrice, String timestamp) {
        this.id = id;
        this.instrumentName = instrumentName;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.timestamp = timestamp;
    }

    public Price() {

    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
        return instrumentName;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public double setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
        return bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public double setAskPrice(double askPrice) {
        this.askPrice = askPrice;
        return askPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
