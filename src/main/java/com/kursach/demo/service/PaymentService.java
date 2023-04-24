package com.kursach.demo.service;

import com.kursach.demo.dto.PaymentDTO;
import com.kursach.demo.entity.Payment;
import com.kursach.demo.repository.PaymentRepository;
import com.kursach.demo.repository.PersonRepository;
import com.kursach.demo.repository.ReceiptRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private PersonRepository personRepository;


    private List<PaymentDTO> paymentTODTOList(List<Payment> paymentList) {
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        for (Payment payment : paymentList) {
            paymentDTOList.add(PaymentDTO.fromEntity(payment));
        }
        return paymentDTOList;
    }

    public PaymentDTO createPayment(Long receiptId,  Long payerId) {
        Payment payment = new Payment();
        payment.setReceipt(receiptRepository.findReceiptByReceiptId(receiptId));
        payment.setPerson(personRepository.findPersonById(payerId));
        return PaymentDTO.fromEntity(paymentRepository.save(payment));
    }

    public List<PaymentDTO> findAAllByPayerId(Long payerId) {
        return paymentTODTOList(paymentRepository.findAllByPaymentId(payerId));
    }
    public List<PaymentDTO> showAllPAyments() {
        return paymentTODTOList(paymentRepository.findAll());
    }

    public void deletePayment(Long payerId) {
        paymentRepository.deletePaymentByPaymentId(payerId);
    }
}
