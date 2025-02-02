package com.example.digitalsignature.service.ImplCrypto;
import com.example.digitalsignature.service.CryptoService;

import org.springframework.stereotype.Service;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

@Service("ECDSAService")
public class ECDSAService implements CryptoService {
    private final KeyPair keyPair;

    public ECDSAService() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        keyGen.initialize(new ECGenParameterSpec("secp256r1"), new SecureRandom());
        this.keyPair = keyGen.generateKeyPair();
    }

    @Override
    public String signMessage(String message) throws Exception {
        Signature signer = Signature.getInstance("SHA256withECDSA");
        signer.initSign(keyPair.getPrivate());
        signer.update(message.getBytes());
        return Base64.getEncoder().encodeToString(signer.sign());
    }

    @Override
    public boolean verifySignature(String message, String signature) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withECDSA");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(message.getBytes());
        return verifier.verify(Base64.getDecoder().decode(signature));
    }
}

