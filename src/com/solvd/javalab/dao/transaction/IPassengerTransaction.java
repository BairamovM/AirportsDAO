package com.solvd.javalab.dao.transaction;

import com.solvd.javalab.dao.entity.Passengers;
import com.solvd.javalab.dao.entity.SeatsFlight;

public interface IPassengerTransaction {

    void bookPlace(Passengers value1, SeatsFlight value2);

}
