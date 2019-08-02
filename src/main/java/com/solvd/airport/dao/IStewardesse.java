package com.solvd.airport.dao;

import com.solvd.airport.entity.Stewardesse;
import java.util.List;

public interface IStewardesse extends DAO <Stewardesse> {

    Stewardesse getByID(Long id);

    Stewardesse getAll();

    Stewardesse save(Stewardesse value);

    void delete(Long id);

    void update(Stewardesse value);

}
