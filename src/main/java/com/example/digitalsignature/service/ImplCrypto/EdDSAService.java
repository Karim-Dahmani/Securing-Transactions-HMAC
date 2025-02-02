package com.example.digitalsignature.service.ImplCrypto;

import com.example.digitalsignature.service.CryptoService;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Base64;

@Service("EdDSAService")
public class EdDSAService implements CryptoService {
    private final KeyPair keyPair;

    public EdDSAService() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("Ed25519");
        this.keyPair = keyGen.generateKeyPair();
    }

    @Override
    public String signMessage(String message) throws Exception {
        Signature signer = Signature.getInstance("Ed25519");
        signer.initSign(keyPair.getPrivate());
        signer.update(message.getBytes());
        return Base64.getEncoder().encodeToString(signer.sign());
    }

    @Override
    public boolean verifySignature(String message, String signature) throws Exception {
        Signature verifier = Signature.getInstance("Ed25519");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(message.getBytes());
        return verifier.verify(Base64.getDecoder().decode(signature));
    }
}

