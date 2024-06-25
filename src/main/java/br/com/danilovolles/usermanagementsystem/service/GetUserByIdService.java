package br.com.danilovolles.usermanagementsystem.service;

import br.com.danilovolles.usermanagementsystem.dto.UserDTO;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDTO> execute(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {

            UserDTO userDTO = new UserDTO();

            userDTO.setName(user.get().getName());
            userDTO.setEmail(user.get().getEmail());
            userDTO.setUsername(user.get().getUsername());
            userDTO.setRole(user.get().getRole());
            userDTO.setCreationDate(user.get().getCreationDate());
            userDTO.setStatus(user.get().getStatus());

            return Optional.of(userDTO);
        }
        return Optional.empty();
    }
}
