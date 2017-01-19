package com.chien.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by chien on 19/01/17.
 */
public class LoanDetails {
    private List<Loan> loanDetails=new ArrayList<>();

    private LoanDetails(){

    }
    public void init(List<Loan> loanList){
        this.loanDetails.addAll(loanList);
    }
    private static LoanDetails instance=new LoanDetails();

    public static LoanDetails getInstance(){
        return instance;
    }

    public BigDecimal getInstallmentPaymentPerYear(int year){
        Stream<Loan> loanStream = loanDetails.stream().filter(loan -> loan.isInTheYear(year));
        BigDecimal total=loanStream.map(e -> e.getInstallmentPayment()).reduce(BigDecimal.ZERO,BigDecimal::add);
         return total;
    }
}
