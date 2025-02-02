package com.example.digitalsignature.service;


public interface CryptoService {
    String signMessage(String message) throws Exception;
    boolean verifySignature(String message, String signature) throws Exception;
}
