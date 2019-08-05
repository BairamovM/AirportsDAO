package com.solvd.airport.xml;

public class AirplaneDOM {

private String airplaneID;
private String airplaneType;
private String numberSeets;
private String rangeFlight;
private String carryingCapacity;
private String teamID;
private String Team_member;
private String Team_memberID;
private String firstName;
private String lastName;
private String experience;
private String passportSerialNumber;
private String Nationalities_id;
private String  citizenship;

    public String  getAirplaneID() {
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

    public String getTeam_member() {
        return Team_member;
    }

    public void setTeam_member(String team_member) {
        this.Team_member = team_member;
    }

    public String getTeam_memberID() {
        return Team_memberID;
    }

    public void setTeam_memberID(String team_memberID) {
        this.Team_memberID = team_memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPassportSerialNumber() {
        return passportSerialNumber;
    }

    public void setPassportSerialNumber(String passportSerialNumber) {
        this.passportSerialNumber = passportSerialNumber;
    }

    public String getNationalities_id() {
        return Nationalities_id;
    }

    public void setNationalities_id(String nationalities_id) {
        this.Nationalities_id = nationalities_id;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public String toString() {
        return "AirplaneDOM {" +
                "airplaneID = " + airplaneID + "\n" +
                "airplaneType = " + airplaneType + '\n' +
                "numberSeets = " + numberSeets + '\n' +
                "rangeFlight = " + rangeFlight + '\n' +
                "carryingCapacity = " + carryingCapacity + '\n' +
                "teamID = " + teamID + '\n' +
                "Team_member = " + Team_member + '\n' +
                "Team_memberID = " + Team_memberID + '\n' +
                "firstName = " + firstName + '\n' +
                "lastName = " + lastName + '\n' +
                "experience = " + experience + '\n' +
                "passportSerialNumber = " + passportSerialNumber + '\n' +
                "Nationalities_id = " + Nationalities_id + '\n' +
                "citizenship = " + citizenship + '\n' +
                '}';
    }
}
