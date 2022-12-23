package com.shiv.user.service.repositories;

import com.shiv.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, String> {
}
