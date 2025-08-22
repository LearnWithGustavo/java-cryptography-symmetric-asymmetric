package com.java.cryptography.controller;

import com.java.cryptography.util.SymmetricEncryptUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/symmetric")
public class SymmetricController {

    /*
    Endpoint para encrypt e decrypt usando criptografia simetrica
    * */

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody String plainText) throws Exception{
        return SymmetricEncryptUtil.encrypt(plainText);
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody String encryptedText) throws Exception{
        return SymmetricEncryptUtil.decrypt(encryptedText);
    }
}
