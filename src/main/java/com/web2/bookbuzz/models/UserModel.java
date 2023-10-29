package com.web2.bookbuzz.models;

import jakarta.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.web2.bookbuzz.dto.requests.create.CreateUserRequest;
import com.web2.bookbuzz.dto.requests.update.UpdateUserRequest;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "url_photo")
    String urlPhoto;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    public UserModel() {
        // Construtor vazio padrão
    }

    public UserModel(CreateUserRequest request) throws NoSuchAlgorithmException {
        this.name = request.name();
        this.urlPhoto = request.url_photo();
        this.email = request.email();
        try {
            setPassword(request.password());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void updateFields(UpdateUserRequest request) {
        if (request.name() != null) {
            this.name = request.name();
        }

        if (request.url_photo() != null) {
            this.urlPhoto = request.url_photo();
        }

        if (request.email() != null) {
            this.email = request.email();
        }

        if (request.password() != null) {
            try {
                setPassword(request.password());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    public UserModel(int id) {
        this.id = id;
    }

    public UserModel(int id, String name, String urlPhoto, String email, String password, String readingNow)
            throws NoSuchAlgorithmException {
        this.id = id;
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.email = email;
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlPhoto(String url_photo) {
        this.urlPhoto = url_photo;
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

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url_photo='" + urlPhoto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
