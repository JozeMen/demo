package com.kursach.demo.repository;

import com.kursach.demo.entity.Payment;
import com.kursach.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAll();
    List<Payment> findAllByPaymentId(Long id);
    List<Payment> findPaymentsByPaymentId(Long id);

    void deletePaymentByPaymentId(Long id);
    void deletePaymentByPerson(Person person);
}
