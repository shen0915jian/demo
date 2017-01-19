package com.chien;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.chien.model.LoanDetails;
import com.chien.util.FileToObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chien.model.Loan;

@SpringBootApplication
public class InvestApplication {

    private static List<Loan> loanList = new ArrayList<>();
    private static String businessLoanPath="/home/chien/code/github/demo/invest/src/main/resources/data/busniess_loan.txt";
    private static String housingProvidentFundPath="/home/chien/code/github/demo/invest/src/main/resources/data/housing_provident_fund_loans.txt";
    public static void main(String[] args) {
        SpringApplication.run(InvestApplication.class, args);
        loanList.addAll(FileToObject.getLoanList(businessLoanPath,1));
        loanList.addAll(FileToObject.getLoanList(housingProvidentFundPath,2));

        LoanDetails.getInstance().init(loanList);
        System.out.println(LoanDetails.getInstance().getInstallmentPaymentPerYear(2016));
    }
}
