package com.sample.spring.project.springboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private String email;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;


}
