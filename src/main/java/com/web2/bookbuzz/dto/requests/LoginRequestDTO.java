package com.web2.bookbuzz.dto.requests;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginRequestDTO {
    private String email;
    private String password;

    public LoginRequestDTO(String email, String password) throws NoSuchAlgorithmException {
        this.email = email;
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    /**
     * @param password Senha em texto plano
     */
    public void setPassword(String password) throws NoSuchAlgorithmException {
        try {        ;

            // Criar uma instância de MessageDigest para o algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Converter a senha em bytes
            byte[] passwordBytes = password.getBytes();

            // Calcular o hash MD5 da senha
            byte[] hashBytes = md.digest(passwordBytes);

            // Converter o hash em uma representação hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte hashByte : hashBytes) {
                sb.append(String.format("%02x", hashByte));
            }

            // Definir o hash MD5 como a senha
            this.password = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Tratar exceções, como NoSuchAlgorithmException
            e.printStackTrace();
            throw new NoSuchAlgorithmException("Erro ao definir a senha do usuário");
        }
    }
}