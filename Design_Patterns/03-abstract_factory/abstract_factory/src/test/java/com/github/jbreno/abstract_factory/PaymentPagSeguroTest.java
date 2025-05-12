package com.github.jbreno.abstract_factory;

import com.github.jbreno.abstract_factory.exceptions.RiskAlertException;
import com.github.jbreno.abstract_factory.exceptions.UnauthorizedCaptureException;
import com.github.jbreno.abstract_factory.operator.Operator;
import com.github.jbreno.abstract_factory.operator.cielo.Cielo;
import com.github.jbreno.abstract_factory.payment.ModulePaymentFactory;
import com.github.jbreno.abstract_factory.payment.Payment;
import com.github.jbreno.abstract_factory.payment.pagSeguro.PagSeguroModulePaymentFactory;
import com.github.jbreno.abstract_factory.riskManager.RiskManager;
import com.github.jbreno.abstract_factory.riskManager.fcontrol.FControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PaymentPagSeguroTest {
    private Payment payment;

    @BeforeEach
    public void setUp() throws Exception {
        ModulePaymentFactory modulePaymentFactory = new PagSeguroModulePaymentFactory();
        payment = new Payment(modulePaymentFactory);
    }

    @Test
    public void shouldAuthorizeSale() throws UnauthorizedCaptureException, RiskAlertException {
        Long authorizationCode = payment.authorize("2222.2222", new BigDecimal("200"));
        Assertions.assertNotNull(authorizationCode);
    }

    @Test
    public void shouldDenyCapture_invalidCard() throws UnauthorizedCaptureException, RiskAlertException {
        Assertions.assertThrows(UnauthorizedCaptureException.class, () -> {
            payment.authorize("5555.2222", new BigDecimal("2000"));
        });
    }

    @Test
    public void shouldGenerateRiskAlert() throws UnauthorizedCaptureException, RiskAlertException {
        Assertions.assertThrows(RiskAlertException.class, () -> {
            payment.authorize("7777.2222", new BigDecimal("5500"));
        });
    }
}
