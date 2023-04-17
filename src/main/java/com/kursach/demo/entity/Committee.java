package com.kursach.demo.entity;

import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="committee", schema = "public")
@Getter
@Setter

public class Committee {
    @Id
    @Column(unique = true, nullable = false)
    private String name;


    @OneToMany(mappedBy = "committee",cascade = CascadeType.ALL)
    private List<Person> people;

}
