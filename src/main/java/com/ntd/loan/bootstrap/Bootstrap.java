package com.ntd.loan.bootstrap;

import com.ntd.loan.domains.Borrower;
import com.ntd.loan.domains.Loan;
import com.ntd.loan.domains.LoanType;
import com.ntd.loan.services.ILoanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private ILoanService iLoanService;

    public Bootstrap(ILoanService iLoanService){
        this.iLoanService = iLoanService;
    }

    @Override
    public void run(String... args) throws Exception {
        Loan loan = Loan.builder()
                .id(1L)
                .requestedAmount(10000.0)
                .termYears(2)
                .termMonths(0)
                .annualInterest(6)
                .type(LoanType.CONSUMER)
                .borrower(
                    Borrower.builder()
                        .name("Jose")
                        .annualIncome(100000.0)
                        .delinquentDebt(false)
                        .annualDebt(3000.0)
                        .creditHistory(6)
                        .build()
                )
                .build();

        System.out.println("adding loans");
        this.iLoanService.addLoan(loan);

        loan = Loan.builder()
                .id(2L)
                .requestedAmount(20000.0)
                .termYears(2)
                .termMonths(0)
                .annualInterest(6)
                .type(LoanType.CONSUMER)
                .borrower(
                        Borrower.builder()
                                .name("Jose")
                                .annualIncome(100000.0)
                                .delinquentDebt(false)
                                .annualDebt(3000.0)
                                .creditHistory(6)
                                .build()
                )
                .build();
        this.iLoanService.addLoan(loan);
        System.out.println("finishing add loans");
    }
}
