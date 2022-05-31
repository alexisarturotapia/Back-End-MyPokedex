package com.modyo.mypokedex.models;


public class Characteristic {

    private Integer id;
    private String characteristic;

    public Characteristic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public String toString() {
        return "Characteristic [characteristic=" + characteristic + ", id=" + id + "]";
    }

    

    

    
}