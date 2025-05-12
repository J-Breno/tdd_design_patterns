package com.github.jbreno.strategy.service.frete;

import com.github.jbreno.strategy.service.OrderShipping;
import com.github.jbreno.strategy.service.Shipping;

public class Sedex implements Shipping {
    public double calculatePrice(int distance) {
        return distance * 1.45 + 12;
    }
}
