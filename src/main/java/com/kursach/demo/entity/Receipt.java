package com.kursach.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="receipt", schema = "public")
@Getter
@Setter

public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receiptId;

    @Temporal(value = TemporalType.DATE)
    private Date writemDate;

    private Long sumOfMoney;
    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL)
    private List<Payment> paymentList;


}
