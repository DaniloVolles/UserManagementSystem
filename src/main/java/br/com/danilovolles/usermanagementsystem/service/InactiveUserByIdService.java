package br.com.danilovolles.usermanagementsystem.service;

import br.com.danilovolles.usermanagementsystem.entity.user.Status;
import br.com.danilovolles.usermanagementsystem.entity.user.User;
import br.com.danilovolles.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InactiveUserByIdService {

    @Autowired
    private UserRepository userRepository;

    public boolean execute(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setStatus(Status.INACTIVE);
            userRepository.save(user.get());
            return true;
        }
        return false;
    }
}
