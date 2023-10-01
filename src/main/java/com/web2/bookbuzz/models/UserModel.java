package com.web2.bookbuzz.models;

import jakarta.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String url_photo;
    String email;
    String password;
    Integer reading_now;

    public UserModel() {
        // Construtor vazio padrão
    }

    public UserModel(int id, String name, String url_photo, String email, String password, Integer reading_now) throws NoSuchAlgorithmException {
        this.id = id;
        this.name = name;
        this.url_photo = url_photo;
        this.email = email;
        setPassword(password);
        this.reading_now = reading_now;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public String getEmail() {
        return email;
    }

    public Integer getReading_now() {
        return reading_now;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @param password Senha em texto plano
     */
    public void setPassword(String password) throws NoSuchAlgorithmException {
        try {
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

    public boolean checkPassword(String password) {
        try {
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

            // Comparar o hash MD5 com a senha armazenada
            return sb.toString().equals(this.password);
        } catch (NoSuchAlgorithmException e) {
            // Tratar exceções, como NoSuchAlgorithmException
            e.printStackTrace();
            // Você pode lançar uma exceção personalizada ou fazer outra coisa aqui
        }
        return false;
    }

    public void setReading_now(Integer reading_now) {
        this.reading_now = reading_now;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url_photo='" + url_photo + '\'' +
                ", email='" + email + '\'' +
                ", reading_now='" + reading_now + '\'' +
                '}';
    }
}
