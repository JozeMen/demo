package com.kursach.demo.service;

import com.kursach.demo.dto.CommitteeDTO;
import com.kursach.demo.dto.ReceiptDTO;
import com.kursach.demo.entity.Committee;
import com.kursach.demo.entity.Payment;
import com.kursach.demo.entity.Person;
import com.kursach.demo.entity.Receipt;
import com.kursach.demo.repository.ReceiptRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    private List<ReceiptDTO> receiptTODTOS(List<Receipt> receiptList) {
        List<ReceiptDTO> receiptDTOList = new ArrayList<>();
        for (Receipt committee : receiptList) {
            receiptDTOList.add(ReceiptDTO.fromEntity(committee));
        }
        return receiptDTOList;
    }

    public ReceiptDTO createReceipt(ReceiptDTO receiptDTO) {
        Receipt receipt = ReceiptDTO.fromDTO((receiptDTO));
        return ReceiptDTO.fromEntity(receiptRepository.save(receipt));
    }

    public List<ReceiptDTO> showAllReceipts() {
        return receiptTODTOS(receiptRepository.findAll());
    }

    public ReceiptDTO showReceiptById(Long id) {
        return ReceiptDTO.fromEntity(receiptRepository.findReceiptByReceiptId(id));
    }

    public void deleteReceiptById(Long id) {
         receiptRepository.deleteReceiptByReceiptId(id);
    }

    public ReceiptDTO editReceipt(Long number, ReceiptDTO receiptDTO) {
        Receipt receipt = ReceiptDTO.fromDTO(receiptDTO);
        Receipt oldReceipt = receiptRepository.findReceiptByReceiptId(number);
        if  (oldReceipt.getPaymentList() != null) {
            List<Payment> paymentList = new ArrayList<>();
            for (Payment payment : oldReceipt.getPaymentList()){
                paymentList.add(payment);
                payment.setReceipt(receipt);
            }
            receipt.setPaymentList(paymentList);
        }
        Receipt newCommittee = receiptRepository.save(receipt);
        receiptRepository.deleteReceiptByReceiptId(number);
        return ReceiptDTO.fromEntity(newCommittee);

    }


}
