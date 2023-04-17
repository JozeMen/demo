package com.kursach.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="people", schema = "public")
@Getter
@Setter

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;
    @Column(name = "homeAddress", unique = true)
    private String homeAddress;
    private String scienceGrade;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "committee_name", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Committee committee;
}
