package com.example.meetland.model;


import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String userId;
    @Column
    private String userPassword;
    @Column
    private String userName;
}
