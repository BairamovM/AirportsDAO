package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.Countries;
import java.util.List;

public interface ICountries {

    Countries getByID(Long id);

    List<Countries> getAll();

    void save(Countries value);

    void delete(Long id);

    void update(Countries value);

}
