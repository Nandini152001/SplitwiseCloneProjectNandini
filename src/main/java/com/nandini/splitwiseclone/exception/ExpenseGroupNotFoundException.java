package com.nandini.splitwiseclone.exception;

public class ExpenseGroupNotFoundException extends RuntimeException{

    public ExpenseGroupNotFoundException(Long id){
        super("Expense group not found with id: " + id);
    }
}
