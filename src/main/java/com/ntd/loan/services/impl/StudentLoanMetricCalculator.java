package com.ntd.loan.services.impl;

import com.ntd.loan.domains.Loan;
import com.ntd.loan.domains.LoanMetric;
import com.ntd.loan.services.ILoanMetricCalculator;
import org.springframework.stereotype.Service;

@Service
public class StudentLoanMetricCalculator implements ILoanMetricCalculator {

    @Override
    public LoanMetric calculateLoanMetric(Loan loan) {
        Double monthlyInterestRate = ( (double)loan.getAnnualInterest() / 12) / 100;
        Double monthlyPayment =
            0.8 *
            (loan.getRequestedAmount() * monthlyInterestRate)
            / ( 1 - Math.pow((1 + monthlyInterestRate),  (double)((-1) * loan.getTermMonths())));

        return LoanMetric.builder()
                .loanType(loan.getType())
                .rate(monthlyInterestRate)
                .payment(monthlyPayment)
                .build();
    }
}
