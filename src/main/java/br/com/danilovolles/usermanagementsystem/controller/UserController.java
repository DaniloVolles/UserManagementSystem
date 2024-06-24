package br.com.danilovolles.usermanagementsystem.controller;

import br.com.danilovolles.usermanagementsystem.dto.UserDataDTO;
import br.com.danilovolles.usermanagementsystem.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping
    public ResponseEntity<UserDataDTO> createUser(@RequestBody UserDataDTO request) {
        Optional<UserDataDTO> response = this.createUserService.execute(request);
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
