package com.gitlab.gduran.shoppingcart;

import java.util.Collection;
import java.util.Set;

public interface CanContainProducts<P extends Product> {

    Set<P> getProducts();
    void setProducts(Collection<P> products);
    long getAmount(P product);
    void setAmount(P product, long amount);
    long increaseAmount(P product);
    long increaseAmount(P product, long amount);
    long decreaseAmount(P product);
    long decreaseAmount(P product, long amount);
}
