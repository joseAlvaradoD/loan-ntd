package com.ntd.loan.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanMetric {
    private LoanType loanType;
    private Double rate;
    private Double payment;
}
