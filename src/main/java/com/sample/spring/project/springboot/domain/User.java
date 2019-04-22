package com.sample.spring.project.springboot.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @Column(unique = true)
    private String email;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;


}
