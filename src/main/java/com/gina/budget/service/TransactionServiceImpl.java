package com.gina.budget.service;

import com.gina.budget.model.Transaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Log4j2
@Service
@Profile("dev")
public class TransactionServiceImpl implements TransactionService{

    private List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getAllTransactions(){
        log.info("getting all transactions...");
        return transactionList;
    }
    public void addTransaction(Transaction transaction){
        log.info("Adding new transaction...");
        transactionList.add(transaction);
    }
    public Transaction viewTransaction(int transactionId){
        log.info("Getting transaction with id:{}", transactionId);
        for(Transaction t:transactionList){
            int id = t.getId();
            if(id==transactionId){
                log.info("transaction found");
                return t;
            }
        }
        log.error("transaction not found");
        return null;
    }
}
