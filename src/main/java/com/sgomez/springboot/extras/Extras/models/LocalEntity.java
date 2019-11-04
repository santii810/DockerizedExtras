package com.sgomez.springboot.extras.Extras.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "local")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "local"})
    private List<ExtraEntity> extras = new ArrayList<ExtraEntity>();

}

