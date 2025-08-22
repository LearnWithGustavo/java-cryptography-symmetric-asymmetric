package com.java.cryptography.controller;

import com.java.cryptography.util.AsymmetricEncryptionUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asymmetric")
public class AsymmetricController {

    /* Na criptografia assimetrica eu preciso fornecer uma chave publica,
    * dessa forma não fornecer não tem como ser realizado essa criptgrafia,
    * pra isso preciso de um endpoint para pegar esse publicKey*/

    @GetMapping("/public-key")
    public String getPublicKey(){
        return AsymmetricEncryptionUtil.getPublicKey();
    }

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody String plainText) throws Exception{
        return AsymmetricEncryptionUtil.encrypt(plainText);
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody String encryptedText) throws Exception{
        return AsymmetricEncryptionUtil.decrypt(encryptedText);
    }
}
