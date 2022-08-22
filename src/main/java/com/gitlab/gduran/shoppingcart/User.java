package com.gitlab.gduran.shoppingcart;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;

public class User {

    private static final AtomicLong idProvider = new AtomicLong();
    private final long id;
    private final String name;
    private final ShoppingCart shoppingCart;

    public User(final long id, final String name, final ShoppingCart shoppingCart) {
        this.id = id;
        this.name = name;
        this.shoppingCart = shoppingCart;
    }

    public User(final String name, final ShoppingCart shoppingCart) {
        this.id = idProvider.incrementAndGet();
        this.name = name;
        this.shoppingCart = shoppingCart;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return getId() == user.getId() &&
                getName().equals(user.getName()) &&
                getShoppingCart().equals(user.getShoppingCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getShoppingCart());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("shoppingCart=" + shoppingCart)
                .toString();
    }
}
