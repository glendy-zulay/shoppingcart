package com.gitlab.gduran.shoppingcart;

import java.math.BigDecimal;

public interface ShoppingCart extends CanContainProducts<SellableProduct> {
    BigDecimal getTotalValue();
}
