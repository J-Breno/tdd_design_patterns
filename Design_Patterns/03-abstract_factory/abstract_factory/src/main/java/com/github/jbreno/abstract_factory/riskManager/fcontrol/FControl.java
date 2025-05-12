package com.github.jbreno.abstract_factory.riskManager.fcontrol;

import com.github.jbreno.abstract_factory.exceptions.RiskAlertException;
import com.github.jbreno.abstract_factory.riskManager.RiskManager;

import java.math.BigDecimal;

public class FControl implements RiskManager {

    @Override
    public void assessRisk(String card, BigDecimal value) throws RiskAlertException {
        if(card.startsWith("7777")) {
            throw new RiskAlertException("Catão suspeito");
        }
    }
}