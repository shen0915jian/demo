package com.chien.util;

import com.chien.model.Loan;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chien on 16/01/17.
 */
public class FileToObject {

    public static List<Loan> getLoanList(String path, int type) {
        if (StringUtils.isEmpty(path)) {
            return Collections.emptyList();
        }
        List<Loan> loans = new ArrayList<>();

        try {
            FileInputStream busniessLoanStream = new FileInputStream(
                    path);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(busniessLoanStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                String[] items = strLine.split(",");
                Loan newLoan = new Loan(LocalDate.parse(items[0].replace("/", "-"), DateTimeFormatter.ISO_LOCAL_DATE), new BigDecimal(items[1]), new BigDecimal(items[2]), new BigDecimal(items[3]), new BigDecimal(items[4]), type);
                loans.add(newLoan);
            }
            // Close the input stream
            busniessLoanStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return loans;
    }
}
