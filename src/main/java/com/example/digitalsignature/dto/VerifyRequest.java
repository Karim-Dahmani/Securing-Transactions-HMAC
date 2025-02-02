package com.example.digitalsignature.dto;

import jakarta.validation.constraints.NotBlank;

public class VerifyRequest {
    @NotBlank
    private String algorithm;

    @NotBlank
    private String message;

    @NotBlank
    private String signature;

    // Getters and Setters
    public String getAlgorithm() { return algorithm; }
    public void setAlgorithm(String algorithm) { this.algorithm = algorithm; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getSignature() { return signature; }
    public void setSignature(String signature) { this.signature = signature; }
}
