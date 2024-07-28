package com.example.pokeapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/api-locales")
    public String apiLocales() {
        return "api-locales";
    }
}

