package br.com.danilovolles.usermanagementsystem.repository;

import br.com.danilovolles.usermanagementsystem.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {}
