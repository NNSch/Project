package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void NegativeRateTest1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(100, 5_000, 0);
        });
    }

    @Test
    public void NegativeRateTest2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(100, 5_000, -10);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "2000,true",
            "10_000,false",
            "0,false"
    })
    public void PayTest(int amount, boolean expected) {
        CreditAccount account = new CreditAccount(3_000, 5_000, 5);
        boolean actual = account.pay(amount);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "2000,true",
            "-100,false",
            "0,false"
    })
    public void AddTest(int amount, boolean expected) {
        CreditAccount account = new CreditAccount(3_000, 5_000, 5);
        boolean actual = account.add(amount);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-200,5000,15,-30",
            "200,5000,10,0",
            "0,5000,10,0"
    })
    public void PercentTest(int initialBalance, int creditLimit, int rate, int expected) {
        CreditAccount account = new CreditAccount(initialBalance, creditLimit, rate);
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }
}
