package br.com.danilovolles.usermanagementsystem.service;

import br.com.danilovolles.usermanagementsystem.dto.UserDTO;
import br.com.danilovolles.usermanagementsystem.entity.user.Role;
import br.com.danilovolles.usermanagementsystem.entity.user.Status;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateUserByIdService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDTO> execute(UUID id, UserDTO userData){

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()){

            user.get().setName(userData.getName());
            user.get().setUsername(userData.getUsername());
            user.get().setEmail(userData.getEmail());
            user.get().setPassword(userData.getPassword());
            user.get().setRole(userData.getRole());
            user.get().setBirthDate(userData.getBirthDate());
            user.get().setAddress(userData.getAddress());
            user.get().setPhone(userData.getPhone());

            userRepository.save(user.get());
            return Optional.of(modelMapper.map(user.get(), UserDTO.class));
        }

        return Optional.empty();
    }
}
