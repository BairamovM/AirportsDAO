package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.Stewardesses;
import java.util.List;

public interface IStewardesses {

    Stewardesses getByID(Long id);

    List<Stewardesses> getAll();

    void save(Stewardesses value);

    void delete(Long id);

    void update(Stewardesses value);

}
