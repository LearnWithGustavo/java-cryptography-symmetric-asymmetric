package com.java.cryptography.controller;

import com.java.cryptography.util.BCryptHashingUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bcrypthash")
public class BCryptController {

    @PostMapping("/hash-password")
    public String hashPassword(@RequestBody String plainPassword){
        return BCryptHashingUtil.hashPassword(plainPassword);
    }

    @PostMapping("/verify-password")
    public boolean verifyPassword(String plainPassword, String hashedPassword){
        return BCryptHashingUtil.verifyPassword(plainPassword, hashedPassword);
    }
}
