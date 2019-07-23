package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.Luggage;
import java.util.List;

public interface ILuggage {

    Luggage getByID(Long id);

    List<Luggage> getAll();

    void save(Luggage value);

    void delete(Long id);

    void update(Luggage value);

}
