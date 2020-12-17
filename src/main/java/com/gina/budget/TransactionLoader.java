package com.gina.budget;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gina.budget.model.Transaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Load the transaction list from a json file.
 */
@Log4j2
@Service
public class TransactionLoader {

    private File jsonFile = new File("src/Transaction.json");
    private List<Transaction> transactionList;

    /**
     * Class constructor reads a json file and add the elements to the list
     */
    public TransactionLoader(){
        ObjectMapper om = new ObjectMapper();
        try {
            log.info("Creating Transaction list from file... ");
            transactionList = om.readValue(jsonFile, new TypeReference<List<Transaction>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}

