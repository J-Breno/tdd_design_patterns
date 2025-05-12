package com.github.jbreno.strategy.service.frete;

import com.github.jbreno.strategy.service.OrderShipping;
import com.github.jbreno.strategy.service.Shipping;

public class Normal implements Shipping {
    public double calculatePrice(int distance) {
        return distance * 1.25 + 10;
    }
}
