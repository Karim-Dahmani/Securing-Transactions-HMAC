package com.example.hmacutil;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACUtil {

    private static final String HMAC_ALGORITHM = "HmacSHA256";

    // Generate a secret key for HMAC
    public static String generateSecretKey() {
        byte[] secretKeyBytes = new byte[32]; // 256-bit key
        new java.security.SecureRandom().nextBytes(secretKeyBytes);
        return Base64.getEncoder().encodeToString(secretKeyBytes);
    }

    // Sign data using the secret key
    public static String signData(String data, String secretKey) throws Exception {
        SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), HMAC_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(key);
        byte[] hmacBytes = mac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hmacBytes);
    }

    // Verify the HMAC signature
    public static boolean verifySignature(String data, String signature, String secretKey) throws Exception {
        String calculatedSignature = signData(data, secretKey);
        return calculatedSignature.equals(signature);
    }


}
