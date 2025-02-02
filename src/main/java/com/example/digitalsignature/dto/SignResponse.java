package com.example.digitalsignature.dto;

public class SignResponse {
    private String signature;

    public SignResponse(String signature) { this.signature = signature; }
    public String getSignature() { return signature; }
}
