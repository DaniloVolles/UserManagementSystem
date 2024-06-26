package br.com.danilovolles.usermanagementsystem.entity.user;

import br.com.danilovolles.usermanagementsystem.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "db_users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
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
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    private Date birthDate;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.valueOf(String.valueOf(Status.ACTIVE));

    private String address;
    
    private String phone;

    public User(UserDTO userData) {
        this.name = userData.getName();
        this.username = userData.getUsername();
        this.email = userData.getEmail();
        this.password = userData.getPassword();
        this.role = userData.getRole();
        this.birthDate = userData.getBirthDate();
        this.creationDate = userData.getCreationDate();
        this.status = userData.getStatus();
        this.address = userData.getAddress();
        this.phone = userData.getPhone();
    }

    public User() {

    }
}
