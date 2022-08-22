package com.gitlab.gduran.shoppingcart;

import java.math.BigDecimal;

public interface StockableProduct extends SellableProduct {

    BigDecimal getPrice();

    BigDecimal getCost();
}
