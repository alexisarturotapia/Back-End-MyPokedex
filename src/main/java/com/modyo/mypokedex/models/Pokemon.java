package com.modyo.mypokedex.models;

import java.util.ArrayList;

public class Pokemon {

    private Integer id;
    private String name;
    private ArrayList<String> types; 
    private Integer weight;
    private ArrayList<String> abilities;
        private String image;

    public Pokemon(Integer id, String name, ArrayList<String> types, Integer weight, ArrayList<String> abilities, String image) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.weight = weight;
        this.abilities = abilities;
        this.image = image;
    }

    public Pokemon(String name) {
		this.name = name;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Pokemon [abilities=" + abilities + ", id=" + id + ", image=" + image + ", name=" + name + ", types="
                + types + ", weight=" + weight + "]";
    }

}
