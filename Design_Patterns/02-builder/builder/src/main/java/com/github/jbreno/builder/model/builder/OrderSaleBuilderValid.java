package com.github.jbreno.builder.model.builder;

import com.github.jbreno.builder.model.OrderSale;

public class OrderSaleBuilderValid { // Criado para obrigar que tenha número
    private OrderSale instace;

    public OrderSaleBuilderValid(OrderSale instace) {
        this.instace = instace;
    }

    public OrderSale build() {
        return instace;
    }
}
