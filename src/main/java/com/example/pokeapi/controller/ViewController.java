package com.example.pokeapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
public class ViewController {
    @GetMapping("/payment")
    public String paymentPage() {
        return "api-payment"; // El nombre del archivo HTML sin la extensión
    }
}
