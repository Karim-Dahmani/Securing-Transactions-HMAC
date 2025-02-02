package com.example.digitalsignature.service.ImplCrypto;

import com.example.digitalsignature.service.CryptoService;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Base64;

@Service("RSAService")
public class RSAService implements CryptoService {
    private final KeyPair keyPair;

    public RSAService() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // RSA key size
        this.keyPair = keyGen.generateKeyPair();
    }

    @Override
    public String signMessage(String message) throws Exception {
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(keyPair.getPrivate());
        signer.update(message.getBytes());
        return Base64.getEncoder().encodeToString(signer.sign());
    }

    @Override
    public boolean verifySignature(String message, String signature) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(message.getBytes());
        return verifier.verify(Base64.getDecoder().decode(signature));
    }
}

