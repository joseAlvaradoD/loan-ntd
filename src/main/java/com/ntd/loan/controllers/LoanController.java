package com.ntd.loan.controllers;

import com.ntd.loan.domains.Loan;
import com.ntd.loan.domains.LoanMetric;
import com.ntd.loan.services.ILoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LoanController.BASE_URL)
@Slf4j
public class LoanController {

    public static final String BASE_URL = "/api/v1/loans";

    private ILoanService iLoanService;

    public LoanController(ILoanService iLoanService){
        this.iLoanService = iLoanService;
    }

    @GetMapping("/{loanId}")
    @ResponseStatus(HttpStatus.OK)
    public Loan getLoan(@PathVariable Long loanId){
        return this.iLoanService.getById(loanId).orElseThrow();
    }

    @GetMapping("/{loanId}/calculate/metric")
    @ResponseStatus(HttpStatus.OK)
    public LoanMetric calculateLoanMetric(@PathVariable Long loanId){
        return this.iLoanService.calculateLoanMetric(loanId).orElseThrow();
    }

    @GetMapping("/max-monthly-payment")
    @ResponseStatus(HttpStatus.OK)
    public Loan getMaxMonthlyPaymentLoan(){
        return this.iLoanService.maxMonthlyPaymentLoan().orElseThrow();
    }

}
