package com.modyo.mypokedex.services;

import java.util.ArrayList;

import com.modyo.mypokedex.exceptions.MyPokedexException;
import com.modyo.mypokedex.exceptions.MyPokedexNotFoundException;
import com.modyo.mypokedex.models.Characteristic;
import com.modyo.mypokedex.models.Evolution;
import com.modyo.mypokedex.models.Pokemon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonServiceImpl implements IPokemonService {

	private static final Logger LOGGER = LogManager.getLogger(PokemonServiceImpl.class);

	private RestTemplate restTemplate;
	private final String POKEMON_ENDPOINT = "https://pokeapi.co/api/v2/pokemon/";
	private final String POKEMON_EVOLUTION_ENDPOINT = "https://pokeapi.co/api/v2/evolution-chain/";
	private final String POKEMON_CHARACTERISTIC_ENDPOINT = "https://pokeapi.co/api/v2/characteristic/";
	private final String LANGUAGE = "es";

	public PokemonServiceImpl(RestTemplate restTemplate) {
    	this.restTemplate = restTemplate;
    }

	@Override
	@Cacheable(cacheNames = "cachePokemons")
    public ArrayList<Pokemon> findAll(String offset){
		LOGGER.info("Ini -> PokemonServiceImpl.findAll");
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		String url = this.POKEMON_ENDPOINT + "?offset={offs}&limit=20";

		try{
			//Obtener listado de pokemons
			JSONObject  results =  new JSONObject(restTemplate.getForObject(url, String.class,offset));
			JSONArray arreglo = results.getJSONArray("results");
			for(int i = 0; i<arreglo.length();i++) {
				JSONObject pokemonI = arreglo.getJSONObject(i);
				JSONObject result = new JSONObject(restTemplate.getForObject(pokemonI.getString("url"), String.class));
				
				//Obteer id del pokemon
				Integer id = result.getInt("id");

				//Obtener imagen del pokemon
				JSONObject sprites = result.getJSONObject("sprites");
				String urlimg ="";
				if(!sprites.isNull("front_default")) {
					urlimg = sprites.getString("front_default");;
				}

				//Obtener peso del pokemon
				Integer weight = result.getInt("weight");

				//Obtener tipos del pokemon
				ArrayList<String> tiposs= new ArrayList<String>();
				JSONArray tipos = result.getJSONArray("types");	
				for(int t = 0;t<tipos.length();t++) {
					String typename = tipos.getJSONObject(t).getJSONObject("type").getString("name");
					tiposs.add(typename);
				}

				//Obtener habilidades del pokemon
				ArrayList<String> habilidadess= new ArrayList<String>();
				JSONArray habilidades = result.getJSONArray("abilities");	
				for(int a = 0; a <habilidades.length(); a++) {
					String abilityname = habilidades.getJSONObject(a).getJSONObject("ability").getString("name");
					habilidadess.add(abilityname);
				}

				//Setear model Pokemon
				Pokemon pokemon = new Pokemon(pokemonI.getString("name"));
				pokemon.setId(id);
				pokemon.setWeight(weight);
				pokemon.setImage(urlimg);
				pokemon.setTypes(tiposs);
				pokemon.setAbilities(habilidadess);
				pokemons.add(pokemon);
			}

			if(pokemons.isEmpty()){
				throw new MyPokedexNotFoundException(0);
			}

			return pokemons;

		}catch(RuntimeException ex){
			throw new MyPokedexException(ex);
		}
	}


	@Override
	@Cacheable(cacheNames = "cachePokemons", condition="#id > 0")
	public Evolution findEvolution(Integer id) {
		LOGGER.info("Ini -> PokemonServiceImpl.findEvolution");
		Evolution evolution = new Evolution(id);
		String url = this.POKEMON_EVOLUTION_ENDPOINT + id.toString() + "/";

		try{
			JSONObject result =  new JSONObject(restTemplate.getForObject(url, String.class));
			JSONObject chain = result.getJSONObject("chain");
			JSONArray evolves_to = chain.getJSONArray("evolves_to");
			String name = evolves_to.getJSONObject(0).getJSONObject("species").getString("name");
			evolution.setEvolution(name);
			if(evolution.getEvolution().isEmpty()){
				throw new MyPokedexNotFoundException(id);
			}
			return evolution;
		}catch(RuntimeException ex){
			throw new MyPokedexException(ex);
		}
	}


	@Override
	@Cacheable(cacheNames = "cachePokemons", condition="#id > 0")
	public Characteristic findDescription(Integer id){
		LOGGER.info("Ini -> PokemonServiceImpl.findDescription");
		Characteristic characteristic = new Characteristic(id);
		String url = this.POKEMON_CHARACTERISTIC_ENDPOINT + id.toString() + "/";

		try{
			JSONObject result =  new JSONObject(restTemplate.getForObject(url, String.class));
			JSONArray descriptions = result.getJSONArray("descriptions");
			for(int d = 0; d<descriptions.length();d++) {
				String name = descriptions.getJSONObject(d).getJSONObject("language").getString("name");
				if(this.LANGUAGE.equals(name)){
					String auxDescription = descriptions.getJSONObject(d).getString("description");
					characteristic.setCharacteristic(auxDescription);
				}
			}
			if(characteristic.getCharacteristic().isEmpty()){
				throw new MyPokedexNotFoundException(id);
			}
			return characteristic;

		}catch(RuntimeException ex){
			throw new MyPokedexException(ex);
		}
		
	}


	@Override
	@CacheEvict(cacheNames = "cachePokemons", allEntries = true)
	public void flushCache() {
		LOGGER.info("Ini -> PokemonServiceImpl.flushCache");
	}
    
}
