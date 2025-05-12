package com.github.jbreno.abstract_factory.payment;

import com.github.jbreno.abstract_factory.exceptions.RiskAlertException;
import com.github.jbreno.abstract_factory.exceptions.UnauthorizedCaptureException;
import com.github.jbreno.abstract_factory.operator.Operator;
import com.github.jbreno.abstract_factory.riskManager.RiskManager;

import java.math.BigDecimal;

public class Payment {
    private Operator operator;
    private RiskManager riskManager;

    public Payment(ModulePaymentFactory modulePaymentFactory) {
        this.operator = modulePaymentFactory.createOperator();
        this.riskManager = modulePaymentFactory.createRiskManager();
    }

    public Long authorize(String card, BigDecimal value) throws UnauthorizedCaptureException, RiskAlertException {
        this.operator.capture(card, value);
        this.riskManager.assessRisk(card, value);
        return this.operator.confirmation();
    }
}
