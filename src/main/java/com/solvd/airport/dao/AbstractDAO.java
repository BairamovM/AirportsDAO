package com.solvd.airport.dao;

public abstract class AbstractDAO {

    private Long id;

    public AbstractDAO () {
    }

    public AbstractDAO (Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
