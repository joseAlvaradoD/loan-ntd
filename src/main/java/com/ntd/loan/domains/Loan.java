package com.ntd.loan.domains;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Loan {
    private Long id;
    private Double requestedAmount;
    private Integer termYears;
    private Integer termMonths;
    private Integer annualInterest;
    private LoanType type;
    private Long loanOfficerId;

    private Borrower borrower;
    private LoanMetric loanMetric = LoanMetric.builder().build();

    public Integer getTermMonths(){
        if (this.termMonths == null || this.termMonths.intValue() == 0){
            return this.termYears * 12;
        }
        else return this.termMonths;
    }

    public Double getPayment(){
        return this.loanMetric != null? this.loanMetric.getPayment() : 0.0;
    }
}
