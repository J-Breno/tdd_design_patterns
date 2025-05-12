package com.github.jbreno.abstract_factory.payment.payPal;

import com.github.jbreno.abstract_factory.operator.Operator;
import com.github.jbreno.abstract_factory.operator.redeCard.RedeCard;
import com.github.jbreno.abstract_factory.payment.ModulePaymentFactory;
import com.github.jbreno.abstract_factory.riskManager.RiskManager;
import com.github.jbreno.abstract_factory.riskManager.clearSale.ClearSale;

public class PayPalModulePaymentFactory implements ModulePaymentFactory {
    @Override
    public Operator createOperator() {
        return new RedeCard();
    }

    @Override
    public RiskManager createRiskManager() {
        return new ClearSale();
    }
}
