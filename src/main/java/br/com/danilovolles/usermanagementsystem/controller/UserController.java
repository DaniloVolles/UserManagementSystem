package br.com.danilovolles.usermanagementsystem.controller;

import br.com.danilovolles.usermanagementsystem.dto.UserDTO;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import br.com.danilovolles.usermanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private CreateUserService createUserService;
    @Autowired private GetAllUsersService getAllUsersService;
    @Autowired private GetUserByIdService getUserByIdService;
    @Autowired private UpdateUserByIdService updateUserByIdService;
    @Autowired private InactiveUserByIdService inactiveUserByIdService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO data) {
        Optional<UserDTO> response = this.createUserService.execute(data);
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(getAllUsersService.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id) {
        Optional<UserDTO> userData = getUserByIdService.execute(id);
        if (userData.isPresent()) {
            return ResponseEntity.ok(userData.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID id, @RequestBody UserDTO data) {
        Optional<UserDTO> userData = this.updateUserByIdService.execute(id, data);
        if (userData.isPresent()) {
            return ResponseEntity.ok(userData.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> inactiveUser(@PathVariable UUID id) {
        boolean inactive = this.inactiveUserByIdService.execute(id);
        if (inactive) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
