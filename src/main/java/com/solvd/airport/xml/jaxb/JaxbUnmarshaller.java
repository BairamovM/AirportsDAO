package com.solvd.airport.xml.jaxb;

import com.solvd.airport.entity.Airplane;
import com.solvd.airport.entity.Team;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUnmarshaller {

    private static final Logger logJAXB = Logger.getLogger(JaxbUnmarshaller.class);

    public JaxbUnmarshaller() throws JAXBException {

        File file = new File("C:src/main/java/com/solvd/airport/xml/jaxb/Airplane_Jaxb.xml");
        JAXBContext context = JAXBContext.newInstance(Airplane.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Airplane airplane = (Airplane) unmarshaller.unmarshal(file);

        logJAXB.info("Id = " + airplane.getId());
        logJAXB.info("Type = " + airplane.getType());
        logJAXB.info("NumberSeets = " + airplane.getNumberSeets());
        logJAXB.info("RangeFlight = " + airplane.getRangeFlight());
        logJAXB.info("CarryingCapacity = " + airplane.getCarryingCapacity());
        logJAXB.info("Team = " + airplane.getTeam());


    }
}
