package com.ntd.loan.services;

import com.ntd.loan.domains.LoanType;
import com.ntd.loan.services.impl.ConsumerLoanMetricCalculator;
import com.ntd.loan.services.impl.StudentLoanMetricCalculator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoanMetricFactory {

    private Map<LoanType, ILoanMetricCalculator> loanTypeLoanMetricCalculatorMap;

    public LoanMetricFactory(ConsumerLoanMetricCalculator consumerLoanMetricCalculator,
                             StudentLoanMetricCalculator studentLoanMetricCalculator){

        this.loanTypeLoanMetricCalculatorMap = new HashMap<>();
        this.loanTypeLoanMetricCalculatorMap.put(LoanType.STUDENT, studentLoanMetricCalculator);
        this.loanTypeLoanMetricCalculatorMap.put(LoanType.CONSUMER, consumerLoanMetricCalculator);
    }

    public ILoanMetricCalculator getLoanMetricCalculator(LoanType loanType){
        return this.loanTypeLoanMetricCalculatorMap.get(loanType);
    }


}
