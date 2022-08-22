package com.gitlab.gduran.shoppingcart;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.gitlab.gduran.shoppingcart.Impl.DefaultFactory.*;

public class BaseTest {

    protected static final StockableProduct mochaPhone = makeStockableProduct(
            "Mocha",
            "Smartphone",
            "cheap yet very capable device",
            new BigDecimal("200.000"),
            new BigDecimal("299.99"));
    protected static final StockableProduct mochaTablet = makeStockableProduct(
            "Mocha",
            "Tablet",
            "Cheap yet very capable device",
            new BigDecimal("300.00"),
            new BigDecimal("449.99"));

    protected static final StockableProduct mochaLaptop = makeStockableProduct(
            "Mocha",
            "Laptop",
            "Cheap yet very capable device",
            new BigDecimal("600.00"),
            new BigDecimal("859.99"));

    protected static final StockableProduct mahoganyPhone = makeStockableProduct(
            "Mahogany",
            "Smartphone",
            "Beautiful and pretty fancy with a wood finishing",
            new BigDecimal("700.00"),
            new BigDecimal("999.99"));

    protected static final StockableProduct mahoganyLaptop = makeStockableProduct(
            "Mahogany",
            "Laptop",
            "Beautiful and pretty fancy with a wood finishing",
            new BigDecimal("1200.00"),
            new BigDecimal("1800.00"));

    protected static final StockableProduct mahoganyExtendedGuarantee = makeStockableProduct(
            "Mahogany",
            "Extended guarantee",
            "Adds 5 years on top of the 2 years Mahogany's guarantee",
            new BigDecimal("100.00"),
            new BigDecimal("399.99"));

    protected static TestData getTestData() {
        final Inventory inventory = makeInventory();

        final User bob = new User("Bob", makeShoppingCart());

        final User lucas = new User("Lucas", makeShoppingCart());

        final User samantha = new User("Samantha", makeShoppingCart());

        final User jessica = new User("Jessica", makeShoppingCart());

        inventory.setAmount(mochaPhone, 5);
        inventory.setAmount(mochaTablet, 5);
        inventory.setAmount(mochaLaptop, 3);
        inventory.setAmount(mahoganyPhone, 4);
        inventory.setAmount(mahoganyLaptop, 2);
        inventory.setAmount(mahoganyExtendedGuarantee, 4);

        addIntoCart(bob, inventory, mochaPhone, 1);
        addIntoCart(bob, inventory, mochaLaptop, 1);
        addIntoCart(bob, inventory, mochaTablet, 1);

        addIntoCart(lucas, inventory, mahoganyPhone, 1);

        addIntoCart(samantha, inventory, mahoganyPhone, 1);
        addIntoCart(samantha, inventory, mahoganyLaptop, 1);
        addIntoCart(samantha, inventory, mahoganyExtendedGuarantee, 1);

        addIntoCart(jessica, inventory, mochaLaptop, 1);
        addIntoCart(jessica, inventory, mahoganyPhone, 1);
        addIntoCart(jessica, inventory, mahoganyExtendedGuarantee, 1);

        return new TestData(inventory, Arrays.asList(bob, lucas, samantha, jessica));
    }

    protected static void addIntoCart(
            final User user,
            final Inventory inventory,
            final StockableProduct product,
            final long amount) {
        inventory.decreaseAmount(product, amount);
        user.getShoppingCart().increaseAmount(product, amount);
    }

    protected static final class TestData {

        private final Inventory inventory;

        private final List<User> users;

        public TestData(final Inventory inventory, final List<User> users) {
            this.inventory = inventory;
            this.users = users;
        }

        public Inventory getInventory() {
            return inventory;
        }

        public List<User> getUsers() {
            return users;
        }
    }
}
