package com.solvd.airport.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Parser  {

    private static final Logger log = Logger.getLogger(Parser.class);

    public void ParserDoc () {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();

            try {
                Document document = documentBuilder.parse(new File("C:src/main/java/com/solvd/airport/xml/Airplane.xml"));

                Element element = document.getDocumentElement();
                log.info(element.getTagName());


                NodeList nodeList = element.getChildNodes();

                for (int i = 0; i < nodeList.getLength(); i++) {
                    if (nodeList.item(i) instanceof Element) {

                        log.info(((Element) nodeList.item(i)).getTagName());

                        if (((Element) nodeList.item(i)).hasAttribute("firstname"))
                            log.info(((Element) nodeList.item(i)).getAttribute("firstname"));

                        if (nodeList.item(i).hasChildNodes()) {
                            log.info(nodeList.item(i).getChildNodes());
                        }
                    }
                }
            } catch (IOException e) { }
              catch (SAXException e) { }

        } catch (ParserConfigurationException e) { }



    }








}
