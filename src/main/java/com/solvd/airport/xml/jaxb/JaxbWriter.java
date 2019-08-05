package com.solvd.airport.xml.jaxb;

import com.solvd.airport.entity.Airplane;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JaxbWriter {

    private static final Logger logJAXB = Logger.getLogger(JaxbWriter.class);

    public JaxbWriter() throws JAXBException {

        Airplane airplane = new Airplane();
        airplane.setId(1);
        airplane.setType("An-148");
        airplane.setNumberSeets(80);
        airplane.setRangeFlight(2100);
        airplane.setCarryingCapacity(38550);
        airplane.setTeam(1);

        File file = new File("C:src/main/java/com/solvd/airport/xml/jaxb/Airplane_Jaxb.xml");
        JAXBContext context = JAXBContext.newInstance(Airplane.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(airplane, file);
        logJAXB.info(airplane);

    }



}
