package com.kursach.demo.dto;

import com.kursach.demo.entity.Payment;
import com.kursach.demo.entity.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PaymentDTO {
    private Long paymentId;
//    private Long receiptId;
//    private Long payerId;

    public static PaymentDTO fromEntity(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.paymentId = payment.getPaymentId();
//        paymentDTO.receiptId = payment.getReceiptId();
//        paymentDTO.payerId = payment.getPayerId();
        return paymentDTO;
    }
    public static Payment fromDTO(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentDTO.paymentId);
//        payment.setReceiptId(paymentDTO.receiptId);
//        payment.setPayerId(paymentDTO.payerId);
        return payment;
    }



}
