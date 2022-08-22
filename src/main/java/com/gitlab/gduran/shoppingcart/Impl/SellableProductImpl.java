package com.gitlab.gduran.shoppingcart.Impl;

import com.gitlab.gduran.shoppingcart.SellableProduct;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;

public class SellableProductImpl implements SellableProduct {

    private static final AtomicLong referenceProvider = new AtomicLong();

    private final long reference;
    private final String brand;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public SellableProductImpl(long reference, final String brand, final String name,
                               final String description, final BigDecimal price) {
        this.reference = reference;
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public SellableProductImpl(final String brand, final String name,
                               final String description, final BigDecimal price) {
        this(referenceProvider.incrementAndGet(), brand, name, description, price);
    }

    @Override
    public long getReference() {
        return reference;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SellableProductImpl that = (SellableProductImpl) o;
        return getReference() == that.getReference() &&
                getBrand().equals(that.getBrand()) &&
                getName().equals(that.getName()) &&
                getDescription().equals(that.getDescription()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, brand, name, description, price);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SellableProductImpl.class.getSimpleName() + "[", "]")
                .add("reference=" + reference)
                .add("brand='" + brand + "'")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("price=" + price)
                .toString();
    }
}
