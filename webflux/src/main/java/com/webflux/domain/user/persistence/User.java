package com.webflux.domain.user.persistence;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tbl_user")
@Getter
public class User {
    @Id
    private Long id;

    private String name;

    private String password;
}
