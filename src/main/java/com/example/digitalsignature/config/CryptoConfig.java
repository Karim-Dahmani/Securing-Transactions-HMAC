package com.example.digitalsignature.config;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.context.annotation.Configuration;

import java.security.Security;

@Configuration
public class CryptoConfig {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
}
