package com.github.jbreno.abstract_factory.operator.cielo;

import com.github.jbreno.abstract_factory.exceptions.UnauthorizedCaptureException;
import com.github.jbreno.abstract_factory.operator.Operator;

import java.math.BigDecimal;

public class Cielo implements Operator {
    private Long confirmationCode = -1L;

    @Override
    public void capture(String card, BigDecimal amount) throws UnauthorizedCaptureException {
        if(card.startsWith("5555")) {
            throw new UnauthorizedCaptureException("Número de cartão inválido!");
        }

        this.confirmationCode = (long) Math.random() * 1000;
    }

    @Override
    public Long confirmation() {
        System.out.println("Fazendo o débido na conta do cliente via Cielo");
        return confirmationCode;
    }
}
