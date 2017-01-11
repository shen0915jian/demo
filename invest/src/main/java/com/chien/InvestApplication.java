package com.chien;

import java.io.*;
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
                    "/home/chien/github/demo/invest/src/main/resources/data/busniess_loan.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(busniessLoanStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                System.out.println(strLine);
                String[] items = strLine.split(",");

            }
            // Close the input stream
            busniessLoanStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
