package com.example.pokeapi.controller;

import com.example.pokeapi.consultaPokeApi.ConsultaPokeApi;
import com.example.pokeapi.consultaPokeApi.PokeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class PokemonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/api-local")
    public String apiLocal(@RequestParam(name="name", required=false, defaultValue="charizard") String name, Model model) {
        String url = "http://localhost:8080/buscar-poke/" + name;
        try {
            PokeConsulta pokemon = restTemplate.getForObject(url, PokeConsulta.class);
            model.addAttribute("pokemon", pokemon);
        } catch (HttpClientErrorException e) {
            model.addAttribute("error", "Pokémon no encontrado");
        }
        return "api-local";
    }
}

