package br.com.danilovolles.usermanagementsystem.service;

import br.com.danilovolles.usermanagementsystem.dto.UserDataDTO;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDataDTO> execute(UserDataDTO userData){
        User user = new User(userData);
        userRepository.saveAndFlush(user);
        return Optional.of(userData);
    }
}
