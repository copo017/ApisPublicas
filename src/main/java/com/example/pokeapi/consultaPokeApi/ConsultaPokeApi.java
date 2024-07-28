package com.example.pokeapi.consultaPokeApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//https://www.youtube.com/watch?v=biCJIlqA334
@RestController
@RequestMapping("buscar-poke")
public class ConsultaPokeApi {
    @GetMapping("{poke}")
    public PokeConsulta consultaPoke(@PathVariable("poke") String poke){
         RestTemplate restTemplate = new RestTemplate();
         ResponseEntity<PokeConsulta> resp =
                 restTemplate.
                         getForEntity(String.format("https://pokeapi.co/api/v2/pokemon/%s", poke),
                                 PokeConsulta.class);
         return resp.getBody();
     }
}
