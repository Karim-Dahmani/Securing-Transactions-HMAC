package com.example.digitalsignature.util;
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

    public static String signData(byte[] data, String secret) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), HMAC_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(secretKeySpec);
        byte[] signatureBytes = mac.doFinal(data);
        // return DatatypeConverter.printHexBinary(signatureBytes);
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    // Verify the HMAC signature

    public static boolean verifySignature(String SignDoc, String secret) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), HMAC_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        String[] signatureBytes = SignDoc.split("_._");
        String doc = signatureBytes[0];
        String DocSignature = signatureBytes[1];
        mac.init(secretKeySpec);
        byte[] signatureBytes1 = mac.doFinal(doc.getBytes());
        String Base64Sign = Base64.getEncoder().encodeToString(signatureBytes1);
        return Base64Sign.equals(DocSignature);
    }

}
