package com.fredau.homeshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {
    private String outpout;
    private Writer writerMock = new Writer() {
        @Override
        public void start() {
            outpout = "";
        }

        @Override
        public void writeLine(String line) {
            outpout += line + "%n";
        }

        @Override
        public void stop() {

        }
    };
    private Product cafe = new Product("Philips HD7866/61", "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses", 79.99);
    private Product tv = new Television("TV Samsung UE49MU6292","Smart tv ed incurvé 49\"", 599.0,49,"Led");
    private Fridge fridge = new Fridge("BEKO TSE 1042 F", "Réfrigérateur BEKO 130L - Classe A+ - blanc", 189.0,130,false);
    private Customer customer = new Customer("Thos Frederic", "24 rue du marais, Mevoisins");
    private Delivery lowCostRelayDelivery = new RelayDelivery(27);

    @Test
    public void Given_1productsAndDelivery_When_generatingBill_Then_getGoodLinenumber() {
        Bill bill = new Bill(customer, lowCostRelayDelivery);
        bill.addProduct(tv,1);
        bill.generate(writerMock);
        int linenumber = outpout.split("%n").length;
        assertEquals(17,linenumber);
    }
    @Test
    public void Given_3productsAndDelivery_When_generatingBill_Then_getGoodTotal() {
        Bill bill = new Bill(customer, lowCostRelayDelivery);
        bill.addProduct(tv,1);
        bill.addProduct(fridge,1);
        bill.addProduct(cafe,1);
        assertEquals(870.98, bill.getTotal(), 0.01);
    }
}