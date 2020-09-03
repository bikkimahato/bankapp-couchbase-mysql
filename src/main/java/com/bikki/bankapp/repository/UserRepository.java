package com.bikki.bankapp.repository;

import com.bikki.bankapp.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);
}
