package com.gitlab.gduran.shoppingcart;

import java.math.BigDecimal;

public interface SellableProduct extends Product {

    BigDecimal getPrice();
}
