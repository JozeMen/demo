package com.kursach.demo.controller;

import com.kursach.demo.dto.PaymentDTO;
import com.kursach.demo.entity.Payment;
import com.kursach.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentComtroller {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentDTO createPayment(@RequestParam Long receiptId, @RequestParam Long payerId) {
        return paymentService.createPayment(receiptId, payerId);
    }

    @GetMapping("/{payerId}")
    public List<PaymentDTO> findAAllByPayerId(@PathVariable Long payerId) {
        return paymentService.findAAllByPayerId(payerId);
    }

    @DeleteMapping("/{payerId}")
    public void deletePayment(@PathVariable Long payerId){
        paymentService.deletePayment(payerId);
    }

/*
    @PutMapping("/{payerId}")
    public PaymentDTO editPerson(@PathVariable Long id, @RequestBody PaymentDTO personDTO) {
        return personService.editPerson(id, personDTO);
    }
*/

}
