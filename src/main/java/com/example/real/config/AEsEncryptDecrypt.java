package com.example.real.config;

import com.example.real.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
@Configuration
public class AEsEncryptDecrypt {
    private SecretKey key;
    @Value("${aes.encryption.key}")
    String encryptionKey;

    public SecretKey getKey() {
        if (key == null) {
            key = new SecretKeySpec(encryptionKey.getBytes(), "AES");
        }

        return key;
    }


    public String encrypt(String algorithm, String input) throws CustomException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, this.getKey(), new IvParameterSpec(new byte[16]));
            byte[] cipherText = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(cipherText);
        }catch (Exception e){
            System.out.println("AEsEncryption: ");
            throw new CustomException("this is error");
        }
    }

    public String decrypt(String algorithm, String cipherText) throws CustomException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, this.getKey(), new IvParameterSpec(new byte[16]));
            byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
            return new String(plainText);
        }catch (Exception e){
            System.out.println("AEsDecryption: ");
            throw new CustomException("this is bad");
        }
    }
}