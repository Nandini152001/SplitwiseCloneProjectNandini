package com.nandini.splitwiseclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ExpenseGroupNotFoundException.class)
    public ResponseEntity<String> handleExpenseGroupNotFound(ExpenseGroupNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidErrors(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(GroupMemberAlreadyExistsException.class)
    public ResponseEntity<String> handleGroupMemberAlreadyExist(GroupMemberAlreadyExistsException ex){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(ex.getMessage());
    }

}
