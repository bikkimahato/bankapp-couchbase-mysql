package com.bikki.bankapp.service;


import com.bikki.bankapp.model.User;
import com.bikki.bankapp.pojos.request.ReqAddUser;
import com.bikki.bankapp.pojos.response.ResAddUser;

public interface UserService {

    ResAddUser create(ReqAddUser reqAddUser);
    User findByUsername(String username);
}
