package com.example.digitalsignature.dto;

public class VerifyResponse {
    private boolean isValid;

    public VerifyResponse(boolean isValid) { this.isValid = isValid; }
    public boolean isValid() { return isValid; }
}
