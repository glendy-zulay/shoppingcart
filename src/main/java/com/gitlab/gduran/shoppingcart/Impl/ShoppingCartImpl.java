package com.gitlab.gduran.shoppingcart.Impl;

import com.gitlab.gduran.shoppingcart.SellableProduct;
import com.gitlab.gduran.shoppingcart.ShoppingCart;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

public class ShoppingCartImpl implements ShoppingCart {

    private final Counter<SellableProduct> content = new Counter<>();

    @Override
    public BigDecimal getTotalValue() {
        return content.getItems()
                .stream()
                .map(product -> product
                        .getPrice()
                        .multiply(BigDecimal.valueOf(content.getCount(product))))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public Set<SellableProduct> getProducts() {
        return content.getItems();
    }

    @Override
    public void setProducts(Collection<SellableProduct> products) {
        content.setItems(products);
    }

    @Override
    public long getAmount(SellableProduct product) {
        return content.getCount(product);
    }

    @Override
    public void setAmount(SellableProduct product, long amount) {
        content.setCount(product, amount);
    }

    @Override
    public long increaseAmount(SellableProduct product) {
        return content.increaseCount(product);
    }

    @Override
    public long increaseAmount(SellableProduct product, long amount) {
        return content.increaseCount(product,amount);
    }

    @Override
    public long decreaseAmount(SellableProduct product) {
        return content.decreaseCount(product);
    }

    @Override
    public long decreaseAmount(SellableProduct product, long amount) {
        return content.decreaseCount(product,amount);
    }
}
