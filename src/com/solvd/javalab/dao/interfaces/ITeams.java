package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.Teams;
import java.util.List;

public interface ITeams {

    Teams getByID(Long id);

    List<Teams> getAll();

    void save(Teams value);

    void delete(Long id);

    void update(Teams value);

}
