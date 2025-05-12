package com.github.jbreno.abstract_factory.payment.pagSeguro;

import com.github.jbreno.abstract_factory.operator.Operator;
import com.github.jbreno.abstract_factory.operator.cielo.Cielo;
import com.github.jbreno.abstract_factory.payment.ModulePaymentFactory;
import com.github.jbreno.abstract_factory.riskManager.RiskManager;
import com.github.jbreno.abstract_factory.riskManager.fcontrol.FControl;

public class PagSeguroModulePaymentFactory implements ModulePaymentFactory {

    @Override
    public Operator createOperator() {
        return new Cielo();
    }

    @Override
    public RiskManager createRiskManager() {
        return new FControl();
    }
}
