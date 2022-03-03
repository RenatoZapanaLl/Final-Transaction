package com.example.MSTransaction.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@RedisHash("Transaction")
public class Transaction implements Serializable
{
    private String Deposit;
    private Date  Fecha;
    private Double Mount;
    private String ValorCompra;
    private String ValorVenta;
    private String DNI ;
    private String NamesClients;


}
