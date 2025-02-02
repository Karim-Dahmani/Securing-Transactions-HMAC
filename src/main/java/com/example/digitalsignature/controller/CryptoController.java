package com.example.digitalsignature.controller;

import com.example.digitalsignature.dto.*;
import com.example.digitalsignature.service.CryptoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Map;

@RestController
@RequestMapping("/crypto")
public class CryptoController {

    private final Map<String, CryptoService> cryptoServices;

    public CryptoController(@Qualifier("EdDSAService") CryptoService eddsaService,
                            @Qualifier("ECDSAService") CryptoService ecdsaService,
                            @Qualifier("RSAService") CryptoService rsaService) {
        this.cryptoServices = Map.of(
                "EdDSA", eddsaService,
                "ECDSA", ecdsaService,
                "RSA", rsaService

        );
    }

    @PostMapping("/sign")
    public ResponseEntity<SignResponse> sign(@Valid @RequestBody SignRequest request) throws Exception {
        CryptoService service = cryptoServices.get(request.getAlgorithm());
        if (service == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new SignResponse(service.signMessage(request.getMessage())));
    }

    @PostMapping("/verify")
    public ResponseEntity<VerifyResponse> verify(@Valid @RequestBody VerifyRequest request) throws Exception {
        CryptoService service = cryptoServices.get(request.getAlgorithm());
        if (service == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new VerifyResponse(service.verifySignature(request.getMessage(), request.getSignature())));
    }
}

