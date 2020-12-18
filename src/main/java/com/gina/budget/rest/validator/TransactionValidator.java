package com.gina.budget.rest.validator;

import com.gina.budget.model.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TransactionValidator {

    public boolean isCorrect(Transaction t){
        if(t==null){
            return false;
        }
        if(t.getAmount()==null){
            return false;
        }
        if(!StringUtils.hasLength(t.getCategory())){
            return false;
        }
        if(!StringUtils.hasLength(t.getStore())){
            return false;
        }
        return StringUtils.hasLength(t.getType());
    }
}
