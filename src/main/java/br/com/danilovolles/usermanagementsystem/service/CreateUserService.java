package br.com.danilovolles.usermanagementsystem.service;

import br.com.danilovolles.usermanagementsystem.dto.UserDTO;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDTO> execute(UserDTO userData){
        User user = new User(userData);
        Date currentDate = new Date();
        user.setCreationDate(currentDate);
        userRepository.saveAndFlush(user);
        return Optional.of(userData);
    }
}
