package com.github.jbreno.builder.model.builder;

import com.github.jbreno.builder.model.Client;
import com.github.jbreno.builder.model.OrderItem;
import com.github.jbreno.builder.model.OrderSale;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderSaleBuilder {
    private OrderSale instace;

    public OrderSaleBuilder() {
        instace = new OrderSale();
    }

    public  OrderSaleBuilder withClientVip(String name) {
        defineClient(name, true);
        return this;
    }

    public  OrderSaleBuilder withoutClientVip(String name) {
        defineClient(name, false);
        return this;
    }

    private void defineClient(String name, boolean vip) {
        Client client = new Client();
        client.setName(name);
        client.setVip(vip);
        instace.setClient(client);
    }

    public OrderSaleBuilder withItem(String name, Integer quantity, String unitPrice) {
        OrderItem item = new OrderItem();
        item.setName(name);
        item.setUnitPrice(new BigDecimal(unitPrice));
        item.setQuantity(quantity);

        if(instace.getOrderItem() == null) {
            instace.setOrderItem(new ArrayList<OrderItem>());
        }

        instace.getOrderItem().add(item);

        return this;
    }

    public OrderSaleBuilderValid withNumber(String number) {
        instace.setNumber(number);
        return new OrderSaleBuilderValid(instace);
    }
}
