package io.shiva.monex.model;

public class Expense {

    private String expenseType;
    private double expenseAmount;
    private String currency;

    public Expense() {
    }

    public Expense(String expenseType, double expenseAmount, String currency) {
        this.expenseType = expenseType;
        this.expenseAmount = expenseAmount;
        this.currency = currency;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
