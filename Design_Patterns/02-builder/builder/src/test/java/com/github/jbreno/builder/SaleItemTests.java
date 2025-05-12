package com.github.jbreno.builder;

import com.github.jbreno.builder.model.Client;
import com.github.jbreno.builder.model.OrderItem;
import com.github.jbreno.builder.model.OrderSale;
import com.github.jbreno.builder.model.builder.OrderSaleBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleItemTests {

    @Test
    public void shouldCalculateTotalValueOrderForClientVip() {
        OrderSale orderSale = new OrderSale();
        Client client = new Client();
        client.setName("João");
        client.setVip(true);
        orderSale.setClient(client);

        OrderItem item1 = new OrderItem();
        item1.setName("Calculadora");
        item1.setUnitPrice(new BigDecimal("200"));
        item1.setQuantity(2);

        OrderItem item2 = new OrderItem();
        item1.setName("Mochila");
        item1.setUnitPrice(new BigDecimal("200"));
        item1.setQuantity(1);

        List<OrderItem> orderItems = Arrays.asList(item1, item2);
        orderSale.setOrderItem(orderItems);

        BigDecimal totalValue = orderSale.getTotalValue();

        assertEquals(new BigDecimal("576").doubleValue(),
            totalValue.doubleValue(),
            0.0001);
    }

    @Test
    public void shouldCalculateTotalValueOrderForClientVipWithBuilder() {
        OrderSale orderSale = new OrderSaleBuilder()
                                .withClientVip("BRENO")
                                .withItem("Calculadora", 2, "200")
                                .withItem("Mochila", 1, "200")
                                .withNumber("093421")
                                .build();


        BigDecimal totalValue = orderSale.getTotalValue();

        assertEquals(new BigDecimal("576").doubleValue(),
                totalValue.doubleValue(),
                0.0001);
    }
}
