package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.Cities;
import java.util.List;

public interface ICities {

    Cities getByID(Long id);

    List<Cities> getAll();

    void save(Cities value);

    void delete(Long id);

    void update(Cities value);

}
