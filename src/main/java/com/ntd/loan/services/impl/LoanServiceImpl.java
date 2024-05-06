package com.ntd.loan.services.impl;

import com.ntd.loan.domains.Loan;
import com.ntd.loan.domains.LoanMetric;
import com.ntd.loan.domains.LoanType;
import com.ntd.loan.services.ILoanMetricCalculator;
import com.ntd.loan.services.ILoanService;
import com.ntd.loan.services.LoanMetricFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LoanServiceImpl implements ILoanService {

    private LoanMetricFactory loanMetricFactory;
    private List<Loan> loans = new ArrayList<>();

    public LoanServiceImpl(LoanMetricFactory loanMetricFactory){
        this.loanMetricFactory = loanMetricFactory;
    }

    @Override
    public Optional<Loan> getById(Long loanId) {
        return
            this.loans.stream()
                .filter(
                    loan->loan.getId().equals(loanId))
                .findFirst();
    }

    @Override
    public Optional<LoanMetric> calculateLoanMetric(Long loanId) {
        return this.loans.stream()
                .filter(
                        loan->loan.getId().equals(loanId))
                .findFirst()
                .map(loan -> {
                    LoanType type = loan.getType();

                    ILoanMetricCalculator loanMetricCalculator = this.loanMetricFactory.getLoanMetricCalculator(type);

                    return loanMetricCalculator.calculateLoanMetric(loan);
                });
    }

    @Override
    public Optional<Loan> maxMonthlyPaymentLoan() {
        Comparator<Loan> comparator = Comparator.comparingDouble(Loan::getPayment);
        return this.loans.stream()
                .map(loan -> {
                    LoanType type = loan.getType();
                    ILoanMetricCalculator loanMetricCalculator = this.loanMetricFactory.getLoanMetricCalculator(type);
                    loan.setLoanMetric(loanMetricCalculator.calculateLoanMetric(loan));
                    return loan;
                }).max(comparator);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }
}
