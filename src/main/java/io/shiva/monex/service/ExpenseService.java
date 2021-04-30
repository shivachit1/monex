package io.shiva.monex.service;

import io.shiva.monex.model.Expense;
import io.shiva.monex.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
    }

    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    @Transactional
    public Expense updateExpense(Long id,Expense expense){
        boolean exists = expenseRepository.existsById(id);
        if(!exists) throw new IllegalStateException("Expense not found");
        Optional<Expense> expense1=expenseRepository.findById(id);
        expense1.get().setExpenseType(expense.getExpenseType());
        expense1.get().setExpenseAmount(expense.getExpenseAmount());
        expense1.get().setCurrency(expense.getCurrency());
        return expenseRepository.save(expense1.get());
    }

    public void deleteExpense(Long id){
        boolean exists = expenseRepository.existsById(id);
        if(!exists) throw new IllegalStateException("Expense not found");
        expenseRepository.deleteById(id);
    }
}

