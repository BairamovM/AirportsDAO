package com.solvd.airport.dao;

import com.solvd.airport.entity.Letters;
import java.util.List;

public interface ILetters {

    Letters getByID(Long id);

    List<Letters> getAll();

    void save(Letters value);

    void delete(Long id);

    void update(Letters value);

}
