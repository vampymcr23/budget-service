package com.gina.budget.rest;

import com.gina.budget.TransactionLoader;
import com.gina.budget.model.Transaction;
import com.gina.budget.rest.validator.TransactionValidator;
import com.gina.budget.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Log4j2
@Service
@Path("/transactions")
public class TransactionRESTSErvice {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionLoader loader;

    @Autowired
    private TransactionValidator validator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactions(){
        log.info("REST get");
        List<Transaction> transactionList = transactionService.getAllTransactions();
        return Response.ok(transactionList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTransaction(Transaction transaction){
        if(validator.isCorrect(transaction)){
            transactionService.addTransaction(transaction);
        }else{
            log.error("error creating the new transaction");
            return Response.status(500).build();
        }
        return Response.ok().build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionList(){
        log.info("Getting transaction list from file");
        List<Transaction> transactionList = loader.getTransactionList();
        return Response.ok(transactionList).build();
    }

    @GET
    @Path("/{tId}")
    public Response getTransaction(@PathParam("tId")int id){
        log.info("searching transaction with id:{}", id);
        Transaction transaction = transactionService.viewTransaction(id);
        if(transaction==null){
            Response.status(404).build();
        }
        return Response.ok().build();
    }
}
