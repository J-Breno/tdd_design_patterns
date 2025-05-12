package com.github.jbreno.abstract_factory.riskManager;

import com.github.jbreno.abstract_factory.exceptions.RiskAlertException;

import java.math.BigDecimal;

public interface RiskManager {
    public void assessRisk(String card, BigDecimal value) throws RiskAlertException;
}
