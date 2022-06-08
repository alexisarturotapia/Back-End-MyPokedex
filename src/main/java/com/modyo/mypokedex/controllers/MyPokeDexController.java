package com.modyo.mypokedex.controllers;

import java.util.ArrayList;
import com.modyo.mypokedex.models.Characteristic;
import com.modyo.mypokedex.models.Evolution;
import com.modyo.mypokedex.models.Pokemon;
import com.modyo.mypokedex.services.IPokemonService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mypokedex")
public class MyPokeDexController {

    private static final Logger LOGGER = LogManager.getLogger(MyPokeDexController.class);

    private final IPokemonService pokemonService;

    public MyPokeDexController(IPokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
	public ResponseEntity<?> findAll(@RequestParam String offset){
        LOGGER.info("Ini -> MyPokeDexController.findAll");
        ArrayList<Pokemon> arrayPokemons = pokemonService.findAll(offset);
        return ResponseEntity.status(HttpStatus.OK).body(arrayPokemons);
       }

    @GetMapping("/evolution/{id}")
	public ResponseEntity<?> findEvolution(@PathVariable("id") Integer id){
        LOGGER.info("Ini -> MyPokeDexController.findEvolution");
        Evolution objEvolution = pokemonService.findEvolution(id);  
        return ResponseEntity.status(HttpStatus.OK).body(objEvolution);
    }

    @GetMapping("/description/{id}")
	public  ResponseEntity<?> findDescription(@PathVariable("id") Integer id) {
        LOGGER.info("Ini -> MyPokeDexController.findDescription");
        Characteristic objCharacteristic = pokemonService.findDescription(id);
        return ResponseEntity.status(HttpStatus.OK).body(objCharacteristic);
	}

    @GetMapping("/flushcache")
    public String flusCache(){
        LOGGER.info("Ini -> MyPokeDexController.flusCache");
        pokemonService.flushCache();
        return "Cache borrada";
    }
}
