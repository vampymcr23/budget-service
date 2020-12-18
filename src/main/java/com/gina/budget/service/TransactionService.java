package com.gina.budget.service;

import com.gina.budget.model.Transaction;

import java.util.List;

/**
 * Interface for transaction services
 */
public interface TransactionService {
     /**
      * Gets all the transactions
      * @return list of transactions
      */
     List<Transaction> getAllTransactions();

     /**
      * Adds a Transaction to the instance variable transactionList
      * @param transaction to add o the list
      */
     void addTransaction(Transaction transaction);

     /**
      * Gets the transaction specified
      * @param transactionId id of the transaction to get
      */
     Transaction viewTransaction(int transactionId);
}
