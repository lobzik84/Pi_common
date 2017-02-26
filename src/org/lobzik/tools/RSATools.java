/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lobzik.tools;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author lobzik
 */
public class RSATools {

    public static RSAPrivateKey getPrivateKey(String key) throws Exception {
        String privKeyPEM = key.replace("-----BEGIN PRIVATE KEY-----\n", "");
        privKeyPEM = privKeyPEM.replace("-----END PRIVATE KEY-----", "");
        privKeyPEM = privKeyPEM.replaceAll("\n", "");
        privKeyPEM = privKeyPEM.replaceAll(" ", "");

        byte[] encoded = Base64.getDecoder().decode(privKeyPEM.trim());
        // PKCS8 decode the encoded RSA private key

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);
        return privKey;

    }

    public static RSAPublicKey getPublicKey(RSAPrivateKey privKey) throws Exception {
        RSAPrivateCrtKey privk = (RSAPrivateCrtKey) privKey;

        RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(privk.getModulus(), privk.getPublicExponent());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKey myPublicKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
        return myPublicKey;
    }

    public static RSAPublicKey getPublicKeyFromPrivate(String key) throws Exception {
        RSAPrivateKey privKey = getPrivateKey(key);

        RSAPrivateCrtKey privk = (RSAPrivateCrtKey) privKey;

        RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(privk.getModulus(), privk.getPublicExponent());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKey myPublicKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
        return myPublicKey;
    }

    public static RSAPublicKey getPublicKey(String key) throws Exception {
        String privKeyPEM = key.replace("-----BEGIN PUBLIC KEY-----\n", "");
        privKeyPEM = privKeyPEM.replace("-----END PUBLIC KEY-----", "");
        privKeyPEM = privKeyPEM.replaceAll("\n", "");
        privKeyPEM = privKeyPEM.replaceAll(" ", "");

        byte[] encoded = Base64.getDecoder().decode(privKeyPEM.trim());
        // PKCS8 decode the encoded RSA private key

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(keySpec);
        return publicKey;

    }

}
