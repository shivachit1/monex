package io.shiva.monex.controller;

import io.shiva.monex.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

import io.shiva.monex.model.Expense;

@RestController
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService){
        this.expenseService=expenseService;
    }

    @GetMapping(path="/expenses",produces = "application/json")
    public List<Expense> getExpenses(){
        return expenseService.getExpenses();
    }

    @PostMapping(path="/expenses")
    public Expense createExpense(@RequestBody Expense expense){
        return expenseService.createExpense(expense);
    }

    @PutMapping(path="/expenses/{id}",produces = "application/json")
    public Expense updateExpense(@PathVariable("id") Long id, @RequestBody Expense expense){
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping(path="/expenses/{id}")
    public void deleteExpense(@PathVariable("id") Long id){
       expenseService.deleteExpense(id);
    }
}
