package com.bikki.bankapp.model;

import com.bikki.bankapp.pojos.request.ReqAddUser;
import com.bikki.bankapp.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class User implements Serializable {

    @Id
    @Field
    private String id;

    @Field
    @NotNull
    private String username;

    @Field
    @NotNull
    private String password;

    @Field
    @NotNull
    private LocalDateTime created;

    @Field
    private LocalDateTime updated;

    public User(ReqAddUser reqAddUser) {
        this.id = Utils.generateRandomUUID();
        this.username = reqAddUser.getUsername();
        this.password = reqAddUser.getPassword();
    }
}
