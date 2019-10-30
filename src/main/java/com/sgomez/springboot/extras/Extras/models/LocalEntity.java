package com.sgomez.springboot.extras.Extras.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "\"local\"")
public class LocalEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

}

