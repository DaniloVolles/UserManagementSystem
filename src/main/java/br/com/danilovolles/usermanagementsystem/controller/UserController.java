package br.com.danilovolles.usermanagementsystem.controller;

import br.com.danilovolles.usermanagementsystem.dto.UserDTO;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import br.com.danilovolles.usermanagementsystem.service.CreateUserService;
import br.com.danilovolles.usermanagementsystem.service.GetAllUsersService;
import br.com.danilovolles.usermanagementsystem.service.GetUserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private GetAllUsersService getAllUsersService;
    @Autowired
    private GetUserByIdService getUserByIdService;

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
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(getUserByIdService.execute(id));
    }
}
