package com.gitlab.gduran.shoppingcart;

import com.gitlab.gduran.shoppingcart.utils.PascalCaseDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(PascalCaseDisplayNameGenerator.class)
public class AppTest extends BaseTest{
    private Inventory inventory;
    private List<User> users;

    @BeforeEach
    void loadTestData(){
        final TestData testData = getTestData();
        inventory = testData.getInventory();
        users = testData.getUsers();
    }

    @Test
    public void basicSanityTest() {
        assertAll("The test data should be correct",
                () -> assertEquals(
                        Set.of(
                                mochaPhone,
                                mochaLaptop,
                                mochaTablet,
                                mahoganyPhone,
                                mahoganyExtendedGuarantee,
                                mahoganyLaptop),
                        inventory.getProducts()),
                () -> Assertions.assertEquals(
                        Set.of("Samanth", "Bob", "Jessica", "Lucas"),
                        users.stream().map(User::getName).collect(Collectors.toSet()))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1 , -10, -100, -1_000_000})
    public void settingProductsToLessThanOneShouldThrownAnException(int amount){
       final IllegalArgumentException exception = assertThrows(
               IllegalArgumentException.class,
               () -> inventory.setAmount(mochaPhone, amount));

       assertEquals("Count must be greater or equals to 0", exception.getMessage());
    }
}
