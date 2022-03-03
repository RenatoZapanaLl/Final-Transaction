package com.example.MSTransaction.Repository;

import com.example.MSTransaction.Domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class TransactionRepository implements RedisRepository {
    private  static final String KEY = "Transaction";

    @Autowired
    private RedisTemplate<String,Transaction> redisTemplate;
    private HashOperations hashOperations;

    public TransactionRepository(RedisTemplate<String, Transaction> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private  void  init(){
        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public Map<String, Transaction> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Transaction findById(String id) {
        return (Transaction) hashOperations.get(KEY,id);
    }

    @Override
    public void save(Transaction transaction) {
        hashOperations.put(KEY, UUID.randomUUID().toString(),transaction);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY,id);
    }
}
