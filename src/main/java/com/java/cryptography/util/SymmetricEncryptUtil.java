package com.java.cryptography.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class SymmetricEncryptUtil {

    private static final String ALGORITHM =  "AES";
    private static final int KEY_SIZE = 128;
    private static SecretKey secretKey;

    /* Uma curiosidade muito interessante sobre criptografia simetrica é que quanto maior o tamanho da chave,
    * mais tempo ela demora para ser gerada e processada e dessa forma mais segura ela é */

    // Trecho de codigo responsavel por inicializar o gerador de chaves
    static{
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(KEY_SIZE);
            secretKey = keyGenerator.generateKey();
        }catch (Exception e){
            throw new RuntimeException("Erro ao inicializar chave AES");
        }
    }

    //Criptografa a cifra e retorna um array de bytes
    public static String encrypt(String data) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData); //Base64 é uma forma de representação
    }

    //Descriptografa a cifra e retorna o valor que tinha sido criptografado
    public static String decrypt(String encryptedData) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }
}
