package br.com.danilovolles.usermanagementsystem.repository;

import br.com.danilovolles.usermanagementsystem.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
