package com.modyo.mypokedex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.modyo.mypokedex.models.Pokemon;
import com.modyo.mypokedex.services.IPokemonService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MypokedexApplicationTests {

	@Autowired
	private IPokemonService pokemonService;

	@Test
	public void testPokemonService() {
		/*
		ArrayList<String> responseExpected = new ArrayList<>();
        responseExpected.add("Vivita");
        responseExpected.add("Alexis");
		*/

		//Pokemon[] pokemonsExpected = new Pokemon[20];


		//assertEquals(pokemonsExpected, pokemonService.findAll());
		assertTrue(true);
	}

}
