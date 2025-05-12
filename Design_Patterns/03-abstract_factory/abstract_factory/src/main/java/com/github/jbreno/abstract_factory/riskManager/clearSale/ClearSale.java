package com.github.jbreno.abstract_factory.riskManager.clearSale;

import com.github.jbreno.abstract_factory.exceptions.RiskAlertException;
import com.github.jbreno.abstract_factory.riskManager.RiskManager;

import java.math.BigDecimal;

public class ClearSale implements RiskManager {
    @Override
    public void assessRisk(String card, BigDecimal amount) throws RiskAlertException {
        if(card.startsWith("1111") && amountTooHigh(amount)){
            throw new RiskAlertException("Valor muito alto para esse cartão");
        }
    }

    private boolean amountTooHigh(BigDecimal amount) {
        BigDecimal limit = new BigDecimal("5000");
        return limit.compareTo(amount) < 0;
    }
}
