package com.example.pokeapi.controller;

import com.example.pokeapi.consultaFlowApi.FlowService;
import com.example.pokeapi.consultaFlowApi.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private FlowService flowService;

    @PostMapping("/create")
    public String createPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            return flowService.createPayment(paymentRequest.getAmount(), paymentRequest.getCurrency(),
                    paymentRequest.getOrderId(), paymentRequest.getConcept(),
                    paymentRequest.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el pago: " + e.getMessage(), e);
        }
    }
}

