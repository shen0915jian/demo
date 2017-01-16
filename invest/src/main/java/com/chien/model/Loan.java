package com.chien.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by chien on 1/11/17.
 */
public class Loan {
    // 还款日期
    private LocalDate repaymentDate;
    // 分期还款金额
    private BigDecimal installmentPayment;
    // 应还本金
    private BigDecimal principal;
    // 应还利息
    private BigDecimal interestRate;
    // 剩余本金
    private BigDecimal principalBalance;

    // 1:商业;2:公积金
    private int type;

    public Loan(LocalDate repaymentDate, BigDecimal installmentPayment, BigDecimal principal, BigDecimal interestRate,
            BigDecimal principalBalance, int type) {
        this.repaymentDate = repaymentDate;
        this.installmentPayment = installmentPayment;
        this.principal = principal;
        this.interestRate = interestRate;
        this.principalBalance = principalBalance;
        this.type = type;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public BigDecimal getInstallmentPayment() {
        return installmentPayment;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public BigDecimal getPrincipalBalance() {
        return principalBalance;
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Loan loan = (Loan) o;

        if (!repaymentDate.equals(loan.repaymentDate))
            return false;
        if (!installmentPayment.equals(loan.installmentPayment))
            return false;
        if (!principal.equals(loan.principal))
            return false;
        return interestRate.equals(loan.interestRate) && principalBalance.equals(loan.principalBalance);
    }

    @Override
    public int hashCode() {
        int result = repaymentDate.hashCode();
        result = 31 * result + installmentPayment.hashCode();
        result = 31 * result + principal.hashCode();
        result = 31 * result + interestRate.hashCode();
        result = 31 * result + principalBalance.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "repaymentDate=" + repaymentDate +
                ", installmentPayment=" + installmentPayment +
                ", principal=" + principal +
                ", interestRate=" + interestRate +
                ", principalBalance=" + principalBalance +
                ", type=" + type +
                '}';
    }

    public boolean isInTheYear(int year) {
        return getRepaymentDate().getYear() == year;
    }
}
