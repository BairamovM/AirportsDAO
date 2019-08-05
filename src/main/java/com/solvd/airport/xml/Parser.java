package com.solvd.airport.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Parser {

    private static final Logger log = Logger.getLogger(Parser.class);

    public Parser() throws ParserConfigurationException, IOException, SAXException {

        File file = new File("C:src/main/java/com/solvd/airport/xml/Airplane.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        AirplaneDOM airplaneDOM = new AirplaneDOM();
        ChiefPilotsDOM chiefPilotsDOM = new ChiefPilotsDOM();
        SecondPilotsDOM secondPilotsDOM = new SecondPilotsDOM();
        StewardessesDOM stewardessesDOM = new StewardessesDOM();


        Element airplaneElement = (Element) document.getElementsByTagName("airplane").item(0);

        NodeList childNodes = airplaneElement.getChildNodes();

        List <AirplaneDOM> airplaneDOMList = new ArrayList<>();
        List <ChiefPilotsDOM> chiefPilotsDOMList = new ArrayList<>();
        List <SecondPilotsDOM> secondPilotsDOMList = new ArrayList<>();
        List <StewardessesDOM> stewardessesDOMList = new ArrayList<>();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNodes.item(i);

                switch (childElement.getNodeName()) {
                    case "id": {
                        airplaneDOM.setAirplaneID(childElement.getTextContent());
                    }
                    break;
                    case "type": {
                        airplaneDOM.setAirplaneType(childElement.getTextContent());
                    }
                    break;
                    case "numberSeets": {
                        airplaneDOM.setNumberSeets(childElement.getTextContent());
                    }
                    break;
                    case "rangeFlight": {
                        airplaneDOM.setRangeFlight(childElement.getTextContent());
                    }
                    break;
                    case "carryingCapacity": {
                        airplaneDOM.setCarryingCapacity(childElement.getTextContent());
                    }
                    break;

                    case "teamID": {
                        airplaneDOM.setTeamID(childElement.getTextContent());
                    }
                    break;

                    //--------------------------------------------------------------------------------

                    case "ChiefPilots_id": {
                        chiefPilotsDOM.setId(childElement.getTextContent());
                    }
                    break;

                    case "firstNameCP": {
                        chiefPilotsDOM.setFirstName(childElement.getTextContent());
                    }
                    break;

                    case "lastNameCP": {
                        chiefPilotsDOM.setLastName(childElement.getTextContent());
                    }
                    break;

                    case "experienceCP": {
                        chiefPilotsDOM.setExperience(childElement.getTextContent());
                    }
                    break;

                    case "passportSerialNumberCP": {
                        chiefPilotsDOM.setPassportSerialNumber(childElement.getTextContent());
                    }
                    break;

                    case "Nationalities_idCP": {
                        chiefPilotsDOM.setNationalities_id(childElement.getTextContent());
                    }
                    break;

                    case "citizenshipCP": {
                        chiefPilotsDOM.setCitizenship(childElement.getTextContent());
                    }
                    break;

                    //--------------------------------------------------------------------------------

                    case "SecondPilots_id": {
                        secondPilotsDOM.setId(childElement.getTextContent());
                    }
                    break;

                    case "firstNameSP": {
                        secondPilotsDOM.setFirstName(childElement.getTextContent());
                    }
                    break;

                    case "lastNameSP": {
                        secondPilotsDOM.setLastName(childElement.getTextContent());
                    }
                    break;

                    case "experienceSP": {
                        secondPilotsDOM.setExperience(childElement.getTextContent());
                    }
                    break;

                    case "passportSerialNumberSP": {
                        secondPilotsDOM.setPassportSerialNumber(childElement.getTextContent());
                    }
                    break;

                    case "Nationalities_idSP": {
                        secondPilotsDOM.setNationalities_id(childElement.getTextContent());
                    }
                    break;

                    case "citizenshipSP": {
                        secondPilotsDOM.setCitizenship(childElement.getTextContent());
                    }
                    break;

                    //--------------------------------------------------------------------------------

                    case "Stewardesses_id": {
                        stewardessesDOM.setId(childElement.getTextContent());
                    }
                    break;

                    case "firstNameST": {
                        stewardessesDOM.setFirstName(childElement.getTextContent());
                    }
                    break;

                    case "lastNameST": {
                        stewardessesDOM.setLastName(childElement.getTextContent());
                    }
                    break;

                    case "experienceST": {
                        stewardessesDOM.setExperience(childElement.getTextContent());
                    }
                    break;

                    case "passportSerialNumberST": {
                        stewardessesDOM.setPassportSerialNumber(childElement.getTextContent());
                    }
                    break;

                    case "Nationalities_idST": {
                        stewardessesDOM.setNationalities_id(childElement.getTextContent());
                    }
                    break;

                    case "citizenshipST": {
                        stewardessesDOM.setCitizenship(childElement.getTextContent());
                    }
                    break;
                }
            }
        }

        airplaneDOMList.add(airplaneDOM);
        chiefPilotsDOMList.add(chiefPilotsDOM);
        secondPilotsDOMList.add(secondPilotsDOM);
        stewardessesDOMList.add(stewardessesDOM);

        log.info(airplaneDOMList);
        log.info(chiefPilotsDOMList);
        log.info(secondPilotsDOMList);
        log.info(stewardessesDOMList);
    }
}
