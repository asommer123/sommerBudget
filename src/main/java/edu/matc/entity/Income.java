package edu.matc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "income")
public class Income {
    private int incomeId;
    private Date payDate;
    private BigDecimal payAmount;
    private int budgetMonthId;
    private BudgetMonth budgetMonthByBudgetMonthId;

    @Id
    @Column(name = "income_id", nullable = false)
    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    @Basic
    @Column(name = "pay_date", nullable = true)
    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Basic
    @Column(name = "pay_amount", nullable = false, precision = 2)
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /*@Basic
    @Column(name = "budget_month_id", nullable = false)
    public int getBudgetMonthId() {
        return budgetMonthId;
    }

    public void setBudgetMonthId(int budgetMonthId) {
        this.budgetMonthId = budgetMonthId;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Income income = (Income) o;

        if (incomeId != income.incomeId) return false;
        //if (budgetMonthId != income.budgetMonthId) return false;
        if (payDate != null ? !payDate.equals(income.payDate) : income.payDate != null) return false;
        if (payAmount != null ? !payAmount.equals(income.payAmount) : income.payAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = incomeId;
        result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
        result = 31 * result + (payAmount != null ? payAmount.hashCode() : 0);
        result = 31 * result + budgetMonthId;
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_month_id", referencedColumnName = "budget_month_id", nullable = false)
    public BudgetMonth getBudgetMonthByBudgetMonthId() {
        return budgetMonthByBudgetMonthId;
    }

    public void setBudgetMonthByBudgetMonthId(BudgetMonth budgetMonthByBudgetMonthId) {
        this.budgetMonthByBudgetMonthId = budgetMonthByBudgetMonthId;
    }
}
