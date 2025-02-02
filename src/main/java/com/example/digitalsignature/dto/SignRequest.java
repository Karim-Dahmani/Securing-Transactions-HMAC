package com.example.digitalsignature.dto;

import jakarta.validation.constraints.NotBlank;

public class SignRequest {
    @NotBlank
    private String algorithm;

    @NotBlank
    private String message;

    // Getters and Setters
    public String getAlgorithm() { return algorithm; }
    public void setAlgorithm(String algorithm) { this.algorithm = algorithm; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
