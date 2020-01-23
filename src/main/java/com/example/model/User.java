package com.example.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="users_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    @NotNull
    private String username;

    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    @NotNull
    private String email;

    public User() {
    }

    public User(String username, String password, String name, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

}