package br.com.danilovolles.usermanagementsystem.service;

import br.com.danilovolles.usermanagementsystem.dto.UserDTO;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllUsersService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> execute() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        users.forEach(user -> {

            UserDTO userDTO = new UserDTO();

            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setRole(user.getRole());
            userDTO.setCreationDate(user.getCreationDate());
            userDTO.setStatus(user.getStatus());

            userDTOs.add(userDTO);
        });
        return userDTOs;
    }
}

