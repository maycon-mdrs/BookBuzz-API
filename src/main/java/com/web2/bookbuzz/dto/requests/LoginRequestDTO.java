package com.web2.bookbuzz.dto.requests;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginRequestDTO {
    private String email;
    private String password;

    public LoginRequestDTO() {
        // default constructor
    }

    public LoginRequestDTO(String email, String password) {
        this.email = email;
        try {
            setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if needed
            e.printStackTrace();
            // Set a default or null password to indicate an error, or throw a different custom exception
        }
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

    public void setPassword(String password) throws NoSuchAlgorithmException {
        // Password hashing logic using MD5
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = password.getBytes();
            byte[] hashBytes = md.digest(passwordBytes);
            StringBuilder sb = new StringBuilder();
            for (byte hashByte : hashBytes) {
                sb.append(String.format("%02x", hashByte));
            }
            this.password = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if needed
            e.printStackTrace();
            throw new NoSuchAlgorithmException("Error while setting the user password");
        }
    }
}
