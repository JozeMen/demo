package com.kursach.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="payment", schema = "public")
@Getter
@Setter

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receipt_receiptId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Receipt receipt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "people_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Person person;


}
