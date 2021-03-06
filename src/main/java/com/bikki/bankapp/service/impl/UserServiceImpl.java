package com.bikki.bankapp.service.impl;

import com.bikki.bankapp.model.User;
import com.bikki.bankapp.pojos.request.ReqAddUser;
import com.bikki.bankapp.pojos.response.ResAddUser;
import com.bikki.bankapp.repository.UserRepository;
import com.bikki.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Qualifier("UserServiceImpl")
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResAddUser create(ReqAddUser reqAddUser) {

        ResAddUser resAddUser = new ResAddUser("success");
        User user = new User(reqAddUser);
        user.setCreated(LocalDateTime.now());
        userRepository.save(user);
        return resAddUser;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        ResAddUser resAddUser = null;
        if (user == null) {
            resAddUser = new ResAddUser("failure");
        }
        resAddUser = new ResAddUser("success");
        return user;
    }

}
