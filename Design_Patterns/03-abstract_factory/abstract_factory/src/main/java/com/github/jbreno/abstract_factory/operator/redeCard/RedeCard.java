package com.github.jbreno.abstract_factory.operator.redeCard;

import com.github.jbreno.abstract_factory.exceptions.UnauthorizedCaptureException;
import com.github.jbreno.abstract_factory.operator.Operator;

import java.math.BigDecimal;

public class RedeCard implements Operator {

    private Long comfirmationCode = -1L;

    @Override
    public void capture(String card, BigDecimal amount) throws UnauthorizedCaptureException {
        if(card.startsWith("2222") && amountTooThanLimit(amount)) {
            throw new UnauthorizedCaptureException("Valor maior que limite para cartão informado");
        }
        this.comfirmationCode = (long) Math.random() * 300;
    }

    private boolean amountTooThanLimit(BigDecimal amount) {
        BigDecimal limit = new BigDecimal("1000");
        return amount.compareTo(limit) > 0;
    }

    @Override
    public Long confirmation() {
        System.out.println("Fazendo o débito na conta do cliente via RedeCard");
        return this.comfirmationCode;
    }
}
