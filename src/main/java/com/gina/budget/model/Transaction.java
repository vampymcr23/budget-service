package com.gina.budget.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transaction {
    int id;
    Date date;
    String type;
    String category;
    String store;
    BigDecimal amount;
}
