package com.kursach.demo.repository;

import com.kursach.demo.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    List<Receipt> findAll();
    List<Receipt> findAllByReceiptId(Long id);
    Receipt findReceiptByReceiptId(Long id);
    void deleteReceiptByReceiptId(Long id);

}
