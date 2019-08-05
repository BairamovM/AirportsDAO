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

    public Parser () throws ParserConfigurationException, IOException, SAXException {

        File file = new File("C:src/main/java/com/solvd/airport/xml/Airplane.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        AirplaneDOM airplaneDOM = new AirplaneDOM();


        Element airplaneElement = (Element) document.getElementsByTagName("airplane").item(0);

        NodeList childNodes = airplaneElement.getChildNodes();

        List <AirplaneDOM> airplaneDOMList = new ArrayList<>();

        for (int i=0; i<childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNodes.item(i);

                switch (childElement.getNodeName()) {
                    case "id" : { airplaneDOM.setAirplaneID(childElement.getTextContent()); } break;
                    case "type" : { airplaneDOM.setAirplaneType(childElement.getTextContent()); } break;
                    case "numberSeets" : { airplaneDOM.setNumberSeets(childElement.getTextContent()); } break;
                    case "rangeFlight" : {airplaneDOM.setRangeFlight(childElement.getTextContent());} break;
                    case "carryingCapacity" : { airplaneDOM.setCarryingCapacity(childElement.getTextContent()); } break;

                }
            }
        }
        airplaneDOMList.add(airplaneDOM);
        airplaneDOMList.forEach(System.out::println);

        Element TeamsElement = (Element) document.getElementsByTagName("Teams").item(7);

    }

}
