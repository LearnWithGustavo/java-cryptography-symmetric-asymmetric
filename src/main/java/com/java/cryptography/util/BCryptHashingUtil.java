package com.java.cryptography.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptHashingUtil {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    // Gera o hash da senha
    public static String hashPassword(String plainPassword){
        return bCryptPasswordEncoder.encode(plainPassword);
    }

    // Verifica se o hashes que voce informou pra verificar se são iguais

    /* Essa metodologia é bastante usada para criptgrafar senhas, pois dessa forma voce não armazena a senha
    e não vai ter informação nenhuma sobre ela, voce irá apenas verificar se as duas que voce esta passando
    são iguais para essa validação*/

    /* O grande detalhe do BCrypt é que não decrypt para o valor original eu apenas verifico se são iguais */
    public static boolean verifyPassword(String plainPassword, String hashedPassword){
        return bCryptPasswordEncoder.matches(hashedPassword, plainPassword);
    }
}
