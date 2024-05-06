package com.ntd.loan.services;

import com.ntd.loan.domains.Loan;
import com.ntd.loan.domains.LoanMetric;

import java.util.Optional;

public interface ILoanService {

    Optional<Loan> getById(Long loanId);
    Optional<LoanMetric> calculateLoanMetric(Long loanId);
    Optional<Loan> maxMonthlyPaymentLoan();
    void addLoan(Loan loan);

}
