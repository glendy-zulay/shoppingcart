package com.gitlab.gduran.shoppingcart.Impl;

import com.gitlab.gduran.shoppingcart.Inventory;
import com.gitlab.gduran.shoppingcart.SellableProduct;
import com.gitlab.gduran.shoppingcart.ShoppingCart;
import com.gitlab.gduran.shoppingcart.StockableProduct;

import java.math.BigDecimal;

public class DefaultFactory {

    public static ShoppingCart makeShoppingCart(){
        return new ShoppingCartImpl();
    }

    public static Inventory makeInventory(){
        return new InventoryImpl();
    }

    public static SellableProduct makeSellableProduct(
            final String brand,
            final String name,
            final String description,
            final BigDecimal price) {
        return new SellableProductImpl(brand,name,description,price);
    }

    public static StockableProduct makeStockableProduct(
            final String brand,
            final String name,
            final String description,
            final BigDecimal cost,
            final BigDecimal price) {
        return new StockableProductImpl(brand, name, description, cost, price);
    }
}
