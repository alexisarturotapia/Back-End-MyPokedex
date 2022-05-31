package com.modyo.mypokedex.services;

import java.util.ArrayList;

import com.modyo.mypokedex.models.Characteristic;
import com.modyo.mypokedex.models.Evolution;
import com.modyo.mypokedex.models.Pokemon;

public interface IPokemonService {

    ArrayList<Pokemon> findAll(String offset);

    Evolution findEvolution(Integer id);

    Characteristic findDescription(Integer id);

    void flushCache();
}
