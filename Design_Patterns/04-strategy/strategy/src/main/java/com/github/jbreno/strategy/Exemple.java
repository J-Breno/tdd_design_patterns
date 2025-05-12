package com.github.jbreno.strategy;

import com.github.jbreno.strategy.service.OrderShipping;
import com.github.jbreno.strategy.service.Shipping;

import java.util.Scanner;

public class Exemple {
    public static void main(String[] args) {
        try(Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe a distancia: ");
            int distancia = entrada.nextInt();
            System.out.print("Qual tipo de frete (1) normal, (2) sedex: ");
            int opcao = entrada.nextInt();
            OrderShipping orderShipping = OrderShipping.values()[opcao - 1];

            Shipping shipping = orderShipping.getShipping();
            double price = shipping.calculatePrice(distancia);
            System.out.printf("O valor total é de R$%.2f", price);
        }
    }
}
