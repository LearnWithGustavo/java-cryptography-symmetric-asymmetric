package com.java.cryptography.util;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class AsymmetricEncryptionUtil {

    private static final String ALGORITHM =  "RSA";
    private static final int KEY_SIZE = 2048;
    private static KeyPair keyPair;


    /* Utilizamos o KeyPairGenerator devido a termos uma publicKey e uma privateKey (duas chaves),
    dessa forma o gerador de cahves precisa me gerar essas duas chaves */

    static{
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
            keyPairGenerator.initialize(KEY_SIZE);
            keyPair = keyPairGenerator.generateKeyPair();
        }catch (Exception e){
            throw new RuntimeException("Erro ao inicializar chave RSA", e);
        }
    }

    //Criptografa a cifra utilizando a chave publica e retorna um array de bytes
    public static String encrypt(String data) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData); //Base64 é uma forma de representação
    }

    //Descriptografa a cifra e retorna o valor que tinha sido criptografado
    public static String decrypt(String encryptedData) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData); //Retorna o texto descriptografado
    }

    //Gera a chave publica
    public static String getPublicKey(){
        return Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
    }
}
