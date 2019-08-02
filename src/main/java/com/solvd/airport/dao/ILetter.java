package com.solvd.airport.dao;

import com.solvd.airport.entity.Letter;
import java.util.List;

public interface ILetter extends DAO <Letter> {

    Letter getByID(Long id);

    Letter getAll();

    Letter save(Letter value);

    void delete(Long id);

    void update(Letter value);

}
