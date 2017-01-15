package com.chien;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chien.model.Loan;

@SpringBootApplication
public class InvestApplication {

    private List<Loan> loanList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(InvestApplication.class, args);

        try {

            FileInputStream busniessLoanStream = new FileInputStream(
                    "/home/chien/code/github/demo/invest/src/main/resources/data/busniess_loan.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(busniessLoanStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                String[] items = strLine.split(",");
                    Loan newLoan=new Loan(LocalDate.parse(items[0].replace("/","-"), DateTimeFormatter.ISO_LOCAL_DATE),new BigDecimal(items[1]),new BigDecimal(items[2]),new BigDecimal(items[3]),new BigDecimal(items[4]),1);
                    System.out.println(newLoan);
            }
            // Close the input stream
            busniessLoanStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
