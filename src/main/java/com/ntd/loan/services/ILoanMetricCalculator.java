package com.ntd.loan.services;

import com.ntd.loan.domains.Loan;
import com.ntd.loan.domains.LoanMetric;

public interface ILoanMetricCalculator {

    LoanMetric calculateLoanMetric(Loan loan);

}
