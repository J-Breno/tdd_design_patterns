package com.github.jbreno.abstract_factory.operator;

import com.github.jbreno.abstract_factory.exceptions.UnauthorizedCaptureException;

import java.math.BigDecimal;

public interface Operator {
    public void capture(String card, BigDecimal amount) throws UnauthorizedCaptureException;
    public Long confirmation();
}
