package com.bikki.bankapp.pojos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqAddUser implements Serializable {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

}