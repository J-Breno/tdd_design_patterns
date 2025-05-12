package com.github.jbreno.strategy.service;

import com.github.jbreno.strategy.service.frete.Normal;
import com.github.jbreno.strategy.service.frete.Sedex;

public enum OrderShipping {
    NORMAL {
        @Override
        public Shipping getShipping() {
            return new Normal();
        }
    },
    SEDEX {
        @Override
        public Shipping getShipping() {
            return new Sedex();
        }
    };

    public abstract Shipping getShipping();
}
