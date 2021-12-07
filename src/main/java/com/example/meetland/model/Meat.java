package com.example.meetland.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Meat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private int isVisible;
    @Column
    private String kind;
    @Column
    private String part;
    @Column
    private String information;
    @Column
    private int price;
}
