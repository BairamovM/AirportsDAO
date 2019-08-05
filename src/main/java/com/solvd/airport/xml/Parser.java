package com.solvd.airport.xml;


import com.solvd.airport.entity.Airplane;
import com.solvd.airport.entity.Airport;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.log4j.Logger;

public class Parser {

    // private Set<Airplane> airplanes;
   // DocumentBuilder documentBuilder;

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




//    public Parser() {
//
//        this.airplanes = new HashSet<Airplane>();
//
//        try {
//
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            documentBuilder = factory.newDocumentBuilder();
//
//        } catch (ParserConfigurationException e) {
//            log.info("Error configuration Parser", e);
//        }
//
//    }
//
//
//    public Set<Airplane> getAirplane() {
//        return airplanes;
//    }
//
//    public void buildSetAirplane() {
//
//        Document document;
//        try {
//
//            // parsing and make tree structure
//            document = documentBuilder.parse(new File("C:src/main/java/com/solvd/airport/xml/Airplane.xml"));
//            Element element = document.getDocumentElement();
//            log.info(element.getTagName());
//
//            // get List child elements
//            NodeList airportList = element.getElementsByTagName("airplaneTeams");
//
//            NodeList nodeList = element.getChildNodes();
//
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                if (nodeList.item(i) instanceof Element) {
//
////                        String value = "";
////                        if (!nodeList.item(i).getTextContent().trim().isEmpty() && !((Text)nodeList.item(i).getFirstChild()).getData().trim().isEmpty() && !((Text)nodeList.item(i).getFirstChild()).getData().trim().equals("\n")) {
////                            Text text = (Text) nodeList.item(i).getFirstChild();
////                            value += " = " + text.getData().trim();
////
////                        }
////                        log.info(nodeList.item(i).getNodeName() + value);
//
//                    log.info(((Element) nodeList.item(i)).getTagName());
//
//
//                    NamedNodeMap attributes = nodeList.item(i).getAttributes();
//                    for (int j = 0; j < attributes.getLength(); j++) {
//
//                        Node attribute = attributes.item(i);
//                        String name = attribute.getNodeName();
//                        String val = attribute.getNodeValue();
//                        log.info("Attributes " + name + "=" + val);
//                    }
//
//
//                    if (((Element) nodeList.item(i)).hasAttribute("id"))
//                        log.info(((Element) nodeList.item(i)).getAttribute("id"));
//
//                    if (nodeList.item(i).hasChildNodes()) {
//                        log.info(nodeList.item(i).getChildNodes());
//                    }
//
//                }
//
//            }
//
//
//        } catch (IOException e) {
//            log.info("File error or I/O error: ", e);
//        } catch (SAXException e) {
//            log.info("Parsing failure: ", e);
//        }
//    }
}
