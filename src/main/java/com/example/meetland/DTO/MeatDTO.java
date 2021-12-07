package com.example.meetland.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeatDTO {
    private long id;
    private int isVisible;
    private String kind;
    private String part;
    private String information;
    private int price;
}
