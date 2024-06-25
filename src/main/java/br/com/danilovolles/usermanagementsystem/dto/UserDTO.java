package br.com.danilovolles.usermanagementsystem.dto;

import br.com.danilovolles.usermanagementsystem.entity.user.Role;
import br.com.danilovolles.usermanagementsystem.entity.user.Status;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String name;
    private String username;
    private String email;
    private String password;
    private Role role;
    private Date birthDate;
    private Date creationDate;
    private Status status;
    private String address;
    private String phone;
}
