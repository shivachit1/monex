package io.shiva.monex.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String passwordHash;

    public User() {

    }
    public User( String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }
    public User(Long id, String name, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
