package com.kursach.demo.repository;

import com.kursach.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAll();
    List<Payment> findAllByPaymentId(Long id);
    Payment findPaymentByPaymentId(Long id);
    void deletePaymentByPaymentId(Long id);
}
