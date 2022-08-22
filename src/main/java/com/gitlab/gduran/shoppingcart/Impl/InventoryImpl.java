package com.gitlab.gduran.shoppingcart.Impl;

import com.gitlab.gduran.shoppingcart.Inventory;
import com.gitlab.gduran.shoppingcart.SellableProduct;
import com.gitlab.gduran.shoppingcart.StockableProduct;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

public class InventoryImpl implements Inventory {

    private final Counter<StockableProduct> stock = new Counter<>();


    @Override
    public Set<StockableProduct> getProducts() {
        return stock.getItems();
    }

    @Override
    public void setProducts(Collection<StockableProduct> products) {
        stock.setItems(products);
    }

    @Override
    public long getAmount(StockableProduct product) {
        return stock.getCount(product);
    }

    @Override
    public void setAmount(StockableProduct product, long amount) {
        stock.setCount(product, amount);
    }

    @Override
    public long increaseAmount(StockableProduct product) {
        return stock.increaseCount(product);
    }

    @Override
    public long increaseAmount(StockableProduct product, long amount) {
        return stock.increaseCount(product, amount);
    }

    @Override
    public long decreaseAmount(StockableProduct product) {
        return stock.decreaseCount(product);
    }

    @Override
    public long decreaseAmount(StockableProduct product, long amount) {
        return stock.decreaseCount(product, amount);
    }

    @Override
    public BigDecimal getTotalCostValue() {
        return stock.getItems()
                .stream()
                .map(product -> product
                        .getCost()
                        .multiply(BigDecimal.valueOf(stock.getCount(product))))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public BigDecimal getTotalPriceValue() {
        return stock.getItems()
                .stream()
                .map(product -> product
                        .getPrice()
                        .multiply(BigDecimal.valueOf(stock.getCount(product))))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
