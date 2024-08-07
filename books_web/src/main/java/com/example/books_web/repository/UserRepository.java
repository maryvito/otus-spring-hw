package com.example.books_web.repository;

import com.example.books_web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryJPA {


    User findUserByUsername(String username);
}
