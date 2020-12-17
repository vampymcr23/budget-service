package com.gina.budget.service;

import com.gina.budget.model.Transaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Log4j2
@Service
@Profile("!dev")
public class TestTransactionServiceImpl implements TransactionService {

    private List<Transaction> transactionList = new ArrayList<>();

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionList;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    @Override
    public Transaction viewTransaction(int transactionId) {
        return transactionList.get(transactionId);
    }
}
