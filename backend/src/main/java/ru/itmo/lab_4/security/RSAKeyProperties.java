package ru.itmo.lab_4.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa")
public record RSAKeyProperties(RSAPublicKey publicKey,
                               RSAPrivateKey privateKey) {
}
