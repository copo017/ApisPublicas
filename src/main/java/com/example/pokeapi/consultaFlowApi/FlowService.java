package com.example.pokeapi.consultaFlowApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class FlowService {

    @Value("${flow.api.key}")
    private String apiKey;

    @Value("${flow.api.secret}")
    private String secretKey;

    @Value("${flow.api.url}")
    private String apiUrl;

    public String createPayment(Double amount, String currency, String orderId, String concept, String email) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> request = new HashMap<>();
        request.put("amount", amount);
        request.put("currency", currency);
        request.put("order_id", orderId);
        request.put("concept", concept);
        request.put("email", email);

        String signature = generateSignature(request);
        request.put("s", signature);

        try {

            String url = apiUrl + "payment/create";
            return restTemplate.postForObject(url, request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al realizar el pago: " + e.getMessage(), e);
        }
    }

    private String generateSignature(Map<String, Object> params) {
        try {

            Map<String, Object> sortedParams = new TreeMap<>(params);


            String toSign = sortedParams.entrySet().stream()
                    .map(entry -> entry.getKey() + entry.getValue().toString())
                    .collect(Collectors.joining());


            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            byte[] hash = sha256_HMAC.doFinal(toSign.getBytes());
            return Base64.getEncoder().encodeToString(hash);

        } catch (Exception e) {
            throw new RuntimeException("Error al generar la firma", e);
        }
    }

}

