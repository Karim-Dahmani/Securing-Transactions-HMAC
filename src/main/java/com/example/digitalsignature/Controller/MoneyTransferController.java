package com.example.digitalsignature.Controller;

import com.example.digitalsignature.DTO.TransferMoneyRequest;
import com.example.digitalsignature.util.HMACUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/transfer")
public class MoneyTransferController {

    // Store secret keys in memory for simplicity (use a database for production)
    private final Map<String, String> userSecretKeys = new HashMap<>();

    // Generate and return a secret key for a user
    @PostMapping("/generate-key")
    public Map<String, String> generateSecretKey(@RequestParam String userId) {
        String secretKey = HMACUtil.generateSecretKey();
        userSecretKeys.put(userId, secretKey);

        Map<String, String> response = new HashMap<>();
        response.put("userId", userId);
        response.put("secretKey", secretKey);
        return response;
    }

    @PostMapping("/sign")
    public Map<String, String> signData(@RequestBody TransferMoneyRequest request, @RequestParam String secretKey) throws Exception {
        // Check if the provided secret key matches the one stored for the user
        String storedSecretKey = userSecretKeys.get(request.getFromAccount());

        if (storedSecretKey == null || !storedSecretKey.equals(secretKey)) {
            throw new IllegalArgumentException("Invalid or missing secret key. Please verify the key or generate a new one.");
        }

        // Prepare the transaction data
        String transactionData = request.getFromAccount() + "|" + request.getToAccount() + "|" + request.getAmount();
        String signature = HMACUtil.signData(transactionData.getBytes(), secretKey);

        Map<String, String> response = new HashMap<>();
        response.put("transactionData", transactionData);
        response.put("signature", signature);
        response.put("secretKey", secretKey); // Optional: return the key for confirmation
        return response;
    }


    // Verify the HMAC signature of the transaction
    @PostMapping("/verify")
    public Map<String, String> verifySignature(@RequestBody Map<String, String> requestBody) throws Exception {
        String userId = requestBody.get("userId");
        String signedDocument = requestBody.get("signedDocument");

        String secretKey = userSecretKeys.get(userId);
        if (secretKey == null) {
            throw new IllegalArgumentException("Secret key for the user not found.");
        }

        boolean isValid = HMACUtil.verifySignature(signedDocument, secretKey);

        Map<String, String> response = new HashMap<>();
        response.put("signedDocument", signedDocument);
        response.put("isValid", String.valueOf(isValid));
        return response;
    }
}
