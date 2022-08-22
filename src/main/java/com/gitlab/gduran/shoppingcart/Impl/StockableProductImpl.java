package com.gitlab.gduran.shoppingcart.Impl;

import com.gitlab.gduran.shoppingcart.StockableProduct;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;

public class StockableProductImpl implements StockableProduct {

    private static final AtomicLong referenceProvider = new AtomicLong();
    private final long reference;
    private final String brand;
    private final String name;
    private final String description;
    private final BigDecimal cost;
    private final BigDecimal price;

    public StockableProductImpl(long reference, final String brand, final String name,
                                 final String description, final BigDecimal cost,
                                 final BigDecimal price) {
        this.reference = reference;
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
    }

    public StockableProductImpl(final String brand, final String name,
                                 final String description, final BigDecimal cost,
                                 final BigDecimal price) {
        this(referenceProvider.incrementAndGet(), brand, name, description, cost, price);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
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
    public BigDecimal getCost() {
        return cost;
    }
    @Override
    public int hashCode() {
        return Objects.hash(
                getReference(),
                getBrand(),
                getName(),
                getDescription(),
                getCost(),
                getPrice());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final StockableProductImpl that = (StockableProductImpl) o;
        return getReference() == that.getReference() &&
                getBrand().equals(that.getBrand()) &&
                getName().equals(that.getName()) &&
                getDescription().equals(that.getDescription()) &&
                getCost().equals(that.getCost()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StockableProductImpl.class.getSimpleName() + "[", "]")
                .add("reference=" + reference)
                .add("brand='" + brand + "'")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("cost=" + cost)
                .add("price=" + price)
                .toString();
    }
}
