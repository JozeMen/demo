package com.kursach.demo.dto;

import com.kursach.demo.entity.Payment;
import com.kursach.demo.entity.Receipt;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

public class ReceiptDTO {
    private Long receiptId;
    private Date writemDate;
    private Long sumOfMoney;
    private List<PaymentDTO> paymentDTOList;

    public static ReceiptDTO fromEntity(Receipt receipt) {
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.receiptId = receipt.getReceiptId();
        receiptDTO.writemDate = receipt.getWritemDate();
        receiptDTO.sumOfMoney = receipt.getSumOfMoney();
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        receiptDTO.setPaymentDTOList(paymentDTOList);
        if (receipt.getPaymentList() != null) {
            for (Payment payment : receipt.getPaymentList()) {
                paymentDTOList.add(PaymentDTO.fromEntity(payment));
            }
        }
        return receiptDTO;
    }

    public static Receipt fromDTO(ReceiptDTO receiptDTO) {
        Receipt receipt = new Receipt();
        receipt.setReceiptId(receiptDTO.getReceiptId());
        receipt.setWritemDate(receiptDTO.getWritemDate());
        receipt.setSumOfMoney(receiptDTO.getSumOfMoney());
        List<Payment> paymentArrayList = new ArrayList<>();
        receipt.setPaymentList(paymentArrayList);
        if (receiptDTO.getPaymentDTOList() != null) {
            for (PaymentDTO paymentDTO : receiptDTO.getPaymentDTOList()) {
                paymentArrayList.add(PaymentDTO.fromDTO(paymentDTO));
            }
        }
        return receipt;
    }

}
