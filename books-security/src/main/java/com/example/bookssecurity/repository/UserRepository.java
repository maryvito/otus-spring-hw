package com.example.bookssecurity.repository;

import com.example.bookssecurity.domain.Book;
import com.example.bookssecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryJPA {


    User findUserByUsername(String username);


}
