package com.github.jbreno.builder.model;

import java.math.BigDecimal;
import java.util.List;

public class OrderSale {
    private String number;
    private Client client;
    private List<OrderItem> orderItem;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItems) {
        this.orderItem = orderItems;
    }

    public BigDecimal getTotalValue() {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItem) {
            totalValue = totalValue.add(orderItem.getUnitPrice()
                    .multiply(new BigDecimal(orderItem.getQuantity())));
        }

        if(client.isVip()) {
            totalValue = totalValue.multiply(new BigDecimal("0.96"));
        }

        return totalValue;
    }
}
