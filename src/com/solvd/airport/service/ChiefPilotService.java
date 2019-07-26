package com.solvd.airport.service;


import com.solvd.airport.dao.IChiefPilot;
import com.solvd.airport.dao.INationality;
import com.solvd.airport.dao.jdbc.ChiefPilotDAO;
import com.solvd.airport.dao.jdbc.NationalityDAO;
import com.solvd.airport.entity.ChiefPilot;

public class ChiefPilotService {

    private INationality nationalityDAO = new NationalityDAO();
    private IChiefPilot chiefPilotDAO = new ChiefPilotDAO();

    public ChiefPilot seeChiefPilot (Long id) {

        ChiefPilot chiefPilot = new ChiefPilot();
        chiefPilot = chiefPilotDAO.getByID(id);
        chiefPilot.setNationality(nationalityDAO.getByID(chiefPilot.getId()));

        return chiefPilot;
    }

    public ChiefPilot saveNewChiefpilot (ChiefPilot chiefPilot) {
        return chiefPilotDAO.save(chiefPilot);
    }

    public void deleteChiefpilotFromList (Long id) {

        chiefPilotDAO.delete(id);
    }

}
