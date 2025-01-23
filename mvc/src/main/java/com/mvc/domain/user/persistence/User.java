package com.mvc.domain.user.persistence;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

}
