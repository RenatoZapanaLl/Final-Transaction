package com.example.MSTransaction.Controller;
import com.example.MSTransaction.Domain.Transaction;
import com.example.MSTransaction.Repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TransactionController {
    private TransactionRepository transactionRepository;

    public TransactionController (TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/Transaction")
    public Map<String, Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @GetMapping("/Transaction/{id}")
    public Transaction findById(@PathVariable String id) {
        return transactionRepository.findById(id);
    }

    @PostMapping("/Transaction")
    public void createClients(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
    }
    @DeleteMapping("/Transaction/{id}")
    public void deleteClients(@PathVariable String id) {
        transactionRepository.delete(id);
    }
}
