package com.nandini.splitwiseclone.controller;

import com.nandini.splitwiseclone.dto.ExpenseRequestDTO;
import com.nandini.splitwiseclone.dto.ExpenseResponseDTO;
import com.nandini.splitwiseclone.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping("/groups/{groupId}")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@PathVariable Long groupId, @RequestBody ExpenseRequestDTO expenseRequestDTO){
        ExpenseResponseDTO expenseResponseDTO = expenseService.createExpense(groupId, expenseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseResponseDTO);
    }

}
