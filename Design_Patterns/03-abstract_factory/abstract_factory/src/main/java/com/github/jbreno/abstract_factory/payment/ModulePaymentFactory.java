package com.github.jbreno.abstract_factory.payment;

import com.github.jbreno.abstract_factory.operator.Operator;
import com.github.jbreno.abstract_factory.riskManager.RiskManager;

public interface ModulePaymentFactory {

    public Operator createOperator();
    public RiskManager createRiskManager();

}
