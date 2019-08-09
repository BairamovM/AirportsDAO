package com.solvd.airport.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlRootElement (name = "Nationality")
public class Nationality {

    private static final Logger logEntity = Logger.getLogger(Nationality.class);

    private Integer id;
    private String citizenship;

    public Integer getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Integer id) {

        try {
            if (id <= 0) {
                logEntity.error("Value id error = " + id);
                throw new EntityException("Value id error = " + id);
            } else if (id >= 1) {
                this.id = id;
            }
        } catch (EntityException e) {
            logEntity.error("Value id error = " + id);
        }
    }

    public String getCitizenship() {
        return citizenship;
    }

    @XmlElement
    public void setCitizenship(String citizenship) {

        try {
            if (citizenship == null) {
                logEntity.error("Value citizenship NULL error = " + citizenship);
                throw new EntityException("Value citizenship NULL error = " + citizenship);
            } else if (citizenship != null) {
                this.citizenship = citizenship;
            }
        } catch (EntityException e) {
            logEntity.error("Value citizenship NULL error = " + citizenship);
        }
    }


    @Override
    public String toString() {
        return "Nationality { " + "\n" +
                "id = " + id + "\n" +
                "citizenship = " + citizenship + "\n" +
                '}' +
                "\n";
    }
}
