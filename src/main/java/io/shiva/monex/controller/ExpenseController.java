package io.shiva.monex.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import io.shiva.monex.model.Expense;

@RestController
public class ExpenseController {
    private final HashMap<Integer,Expense> expenseHashMap = new HashMap<>();
    int i=0;
    @GetMapping(path="/expenses",produces = "application/json")
    public HashMap<Integer, Expense> getAllExpenses(){
        return expenseHashMap;
    }

    @PostMapping(path="/expenses",produces = "application/json")
    public Expense createExpense(@RequestBody Expense expense){
        i++;
        expenseHashMap.put(i,expense);
        return expense;
    }

    @PutMapping(path="/expenses/{id}",produces = "application/json")
    public Expense updateExpense(@PathVariable("id") Integer id, @RequestBody Expense expense){
        expenseHashMap.put(id,expense);
        return expense;
    }

    @DeleteMapping(path="/expenses/{id}")
    public String deleteExpense(@PathVariable("id") Integer id){
        expenseHashMap.remove(id);
        return "successfully deleted";
    }
}
