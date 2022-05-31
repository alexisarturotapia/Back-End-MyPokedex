package com.modyo.mypokedex.models;

public class Evolution {

    private Integer id;
    private String evolution;
    
    public Evolution(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEvolution() {
        return evolution;
    }
    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    @Override
    public String toString() {
        return "Evolution [evolution=" + evolution + ", id=" + id + "]";
    }

    

    
}
