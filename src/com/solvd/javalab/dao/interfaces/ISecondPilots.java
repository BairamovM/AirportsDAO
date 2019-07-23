package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.SecondPilots;
import java.util.List;

public interface ISecondPilots {

    SecondPilots getByID(Long id);

    List<SecondPilots> getAll();

    void save(SecondPilots value);

    void delete(Long id);

    void update(SecondPilots value);

}
