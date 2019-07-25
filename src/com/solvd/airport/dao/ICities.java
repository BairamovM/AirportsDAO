package com.solvd.airport.dao;

import com.solvd.airport.entity.Cities;
import java.util.List;

public interface ICities {

    Cities getByID(Long id);

    List<Cities> getAll();

    void save(Cities value);

    void delete(Long id);

    void update(Cities value);

}
