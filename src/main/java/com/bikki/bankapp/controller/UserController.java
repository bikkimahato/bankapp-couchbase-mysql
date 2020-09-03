package com.bikki.bankapp.controller;

import com.bikki.bankapp.model.User;
import com.bikki.bankapp.pojos.BaseResponse;
import com.bikki.bankapp.pojos.request.ReqAddUser;
import com.bikki.bankapp.pojos.response.ResAddUser;
import com.bikki.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<ResAddUser>> addUser(@RequestBody @Valid ReqAddUser reqAddUser) {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        userService.create(reqAddUser)
                ),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/findByUsername")
    public ResponseEntity<User> findByUsername(@RequestBody String username) {
        return new ResponseEntity<User>(userService.findByUsername(username), HttpStatus.OK);
    }
}
