package com.bikki.bankapp.model;

import com.bikki.bankapp.pojos.request.ReqAddUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
//@EntityListeners(AuditingEntityListener.class)
@Builder
public class User implements Serializable {

    @Id
    @Field
    private long id;

    @Field
    @NotNull
    private String username;

    @Field
    @NotNull
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    public User(ReqAddUser reqAddUser) {
        this.username = reqAddUser.getUsername();
        this.password = reqAddUser.getPassword();
    }
}
