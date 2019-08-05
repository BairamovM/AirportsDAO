package com.solvd.airport.xml;

public class SecondPilotsDOM {

    private String id;
    private String firstName;
    private String lastName;
    private String experience;
    private String passportSerialNumber;
    private String Nationalities_id;
    private String citizenship;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "SecondPilotsDOM { " + "\n" +
                "id = " + id + "\n" +
                "firstName = " + firstName + "\n" +
                "lastName = " + lastName + "\n" +
                "experience = " + experience + "\n" +
                "passportSerialNumber = " + passportSerialNumber + "\n" +
                "Nationalities_id = " + Nationalities_id + "\n" +
                "citizenship = " + citizenship + "\n" +
                '}' +
                "\n";
    }
}
