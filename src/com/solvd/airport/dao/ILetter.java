package com.solvd.airport.dao;

import com.solvd.airport.entity.Letter;
import java.util.List;

public interface ILetter {

    Letter getByID(Long id);

    List<Letter> getAll();

    void save(Letter value);

    void delete(Long id);

    void update(Letter value);

}
