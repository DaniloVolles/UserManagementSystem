package br.com.danilovolles.usermanagementsystem.entity.user;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    private Date birthDate;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private String status = String.valueOf(Status.ACTIVE);

    private String address;
    
    private String phone;
}
