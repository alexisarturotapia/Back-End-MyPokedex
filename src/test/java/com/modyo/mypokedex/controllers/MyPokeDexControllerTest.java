package com.modyo.mypokedex.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.modyo.mypokedex.models.Characteristic;
import com.modyo.mypokedex.models.Evolution;
import com.modyo.mypokedex.models.Pokemon;
import com.modyo.mypokedex.services.IPokemonService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class MyPokeDexControllerTest {

    @InjectMocks
    private MyPokeDexController myPokeDexController;

    @Mock
    private IPokemonService pokemonService;

    @Test
    void testFindAll() {
        String offset = "0";
    
        ArrayList<String> types = new ArrayList<String>();
        types.add("grass");
        types.add("poison");

        ArrayList<String> abilities = new ArrayList<String>();
        abilities.add("overgrow");
        abilities.add("chlorophyll");

        String image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png";

        Pokemon pokemon1 = new Pokemon(1,"bulbasaur", types, 69, abilities, image );
        ArrayList<Pokemon> arrayPokemons = new ArrayList<Pokemon>();
        arrayPokemons.add(pokemon1);

        when(pokemonService.findAll(offset)).thenReturn(arrayPokemons);

        ResponseEntity<?> responsePokemons = myPokeDexController.findAll(offset);
     
        Assertions.assertThat(responsePokemons.getStatusCode().value()).isEqualTo(200);
        assertNotNull(responsePokemons);   
        
    }

    @Test
    void testFindDescription() {

        Integer id = 1;
        Characteristic objCharacteristic = new Characteristic(id);
        objCharacteristic.setCharacteristic("characteristic");

        when(pokemonService.findDescription(id)).thenReturn(objCharacteristic);

        ResponseEntity<Object> responseCharacteristic = myPokeDexController.findDescription(id);
     
        Assertions.assertThat(responseCharacteristic.getStatusCode().value()).isEqualTo(200);
        assertNotNull(responseCharacteristic);   
    }

    @Test
    void testFindEvolution() {
        Integer id = 1;
        Evolution objEvolution = new Evolution(id);
        objEvolution.setEvolution("evolution");

        when(pokemonService.findEvolution(id)).thenReturn(objEvolution);

        ResponseEntity<Object> responseEvolution = myPokeDexController.findEvolution(id);
     
        Assertions.assertThat(responseEvolution.getStatusCode().value()).isEqualTo(200);
        assertNotNull(responseEvolution); 
    }

    
}
