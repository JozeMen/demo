package com.kursach.demo.controller;


import com.kursach.demo.dto.ReceiptDTO;
import com.kursach.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @PostMapping
    public ReceiptDTO createReceipt(@RequestBody ReceiptDTO receiptDTO) {
        return receiptService.createReceipt(receiptDTO);
    }

    @GetMapping("/{id}")
    public ReceiptDTO showReceiptById(@PathVariable Long id) {
        return receiptService.showReceiptById(id);
    }
    @GetMapping
    public List<ReceiptDTO> showAllReceipts() {
        return receiptService.showAllReceipts();
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id){
        receiptService.deleteReceiptById(id);
    }


}
