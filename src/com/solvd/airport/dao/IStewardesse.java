package com.solvd.airport.dao;

import com.solvd.airport.entity.Stewardesse;
import java.util.List;

public interface IStewardesse {

    Stewardesse getByID(Long id);

    List<Stewardesse> getAll();

    void save(Stewardesse value);

    void delete(Long id);

    void update(Stewardesse value);

}
