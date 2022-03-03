package com.example.MSTransaction.Repository;

import com.example.MSTransaction.Domain.Transaction;

import java.util.Map;

public interface RedisRepository {
    Map<String, Transaction> findAll();
    Transaction findById(String id);
    void save(Transaction transaction);
    void delete(String id);
}
