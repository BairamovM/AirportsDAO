package com.solvd.airport.xml;

public class AirplaneDOM {

private String airplaneID;
private String airplaneType;
private String numberSeets;
private String rangeFlight;
private String carryingCapacity;
private String teamID;

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getNumberSeets() {
        return numberSeets;
    }

    public void setNumberSeets(String numberSeets) {
        this.numberSeets = numberSeets;
    }

    public String getRangeFlight() {
        return rangeFlight;
    }

    public void setRangeFlight(String rangeFlight) {
        this.rangeFlight = rangeFlight;
    }

    public String getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(String carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    @Override
    public String toString() {
        return "AirplaneDOM { " + "\n" +
                "airplaneID = " + airplaneID + "\n" +
                "airplaneType = " + airplaneType + "\n" +
                "numberSeets = " + numberSeets + "\n" +
                "rangeFlight = " + rangeFlight + "\n" +
                "carryingCapacity = " + carryingCapacity + "\n" +
                "teamID = " + teamID + "\n" +
                '}' + "\n" +
                "\n";
    }
}
