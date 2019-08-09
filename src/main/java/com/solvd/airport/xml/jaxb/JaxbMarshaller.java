package com.solvd.airport.xml.jaxb;

import com.solvd.airport.entity.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JaxbMarshaller {

    private static final Logger logJAXB = Logger.getLogger(JaxbMarshaller.class);

    public JaxbMarshaller() throws JAXBException {

        Airplane airplane = new Airplane();
        Team team = new Team();
        ChiefPilot chiefPilot = new ChiefPilot();
        SecondPilot secondPilot = new SecondPilot();
        Stewardesse stewardesse = new Stewardesse();
        Nationality nationality = new Nationality();

        nationality.setId(1);
        nationality.setCitizenship("Ukraine");

        chiefPilot.setId(1);
        chiefPilot.setFirstName("John");
        chiefPilot.setLastName("Smith");
        chiefPilot.setExperience(8);
        chiefPilot.setPassportSerialNumber(868687788);
        chiefPilot.setNationality(nationality);

        secondPilot.setId(1);
        secondPilot.setFirstName("Randall");
        secondPilot.setLastName("Perry");
        secondPilot.setExperience(3);
        secondPilot.setPassportSerialNumber(567898908);
        secondPilot.setNationality(nationality);

        stewardesse.setId(1);
        stewardesse.setFirstName("Lilly");
        stewardesse.setLastName("Black");
        stewardesse.setExperience(5);
        stewardesse.setPassportSerialNumber(56578908);
        stewardesse.setNationality(nationality);

        team.setId(1);
        team.setChiefPilot(chiefPilot);
        team.setSecondPilot(secondPilot);
        team.setStewardesse(stewardesse);

        airplane.setId(1);
        airplane.setType("An-148");
        airplane.setNumberSeets(80);
        airplane.setRangeFlight(2100);
        airplane.setCarryingCapacity(38550);
        airplane.setTeam(team);

        File file = new File("C:src/main/java/com/solvd/airport/xml/jaxb/Airplane_Jaxb.xml");
        JAXBContext context = JAXBContext.newInstance(Airplane.class);
        Marshaller marshaller = context.createMarshaller();


        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(airplane, file);

        logJAXB.info(airplane);

    }



}
