package com.ntd.loan.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Borrower {

    private String name;
    private Double annualIncome;
    private Boolean delinquentDebt;
    private Double annualDebt;
    private Integer creditHistory;

}
