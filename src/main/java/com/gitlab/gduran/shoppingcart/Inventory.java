package com.gitlab.gduran.shoppingcart;

import java.math.BigDecimal;

public interface Inventory extends CanContainProducts<StockableProduct> {
    BigDecimal getTotalCostValue();
    BigDecimal getTotalPriceValue();
}
