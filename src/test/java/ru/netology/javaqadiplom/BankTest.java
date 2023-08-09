package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    void successfulTransfer() {
        Bank bank = new Bank();
        Account from = new SavingAccount(1000, 0, 2000, 10);
        Account to = new CreditAccount(0, 1000, 15);

        assertTrue(bank.transfer(from, to, 500));

        assertEquals(500, from.getBalance());
        assertEquals(500, to.getBalance());
    }

    @Test
    void failedTransferNegativeAmount() {
        Bank bank = new Bank();
        Account from = new SavingAccount(1000, 0, 2000, 10);
        Account to = new CreditAccount(0, 1000, 15);

        assertFalse(bank.transfer(from, to, -200));

        assertEquals(1000, from.getBalance());
        assertEquals(0, to.getBalance());
    }

    @Test
    void failedTransferInsufficientFunds() {
        Bank bank = new Bank();
        Account from = new SavingAccount(1000, 0, 2000, 10);
        Account to = new CreditAccount(0, 1000, 15);

        assertFalse(bank.transfer(from, to, 1500));

        assertEquals(1000, from.getBalance());
        assertEquals(0, to.getBalance());
    }

    @Test
    void failedTransferMaxBalance() {
        Bank bank = new Bank();
        Account from = new SavingAccount(1000, 0, 2000, 10);
        Account to = new SavingAccount(1500, 0, 2000, 10);

        assertFalse(bank.transfer(from, to, 600));

        assertEquals(1000, from.getBalance());
        assertEquals(1500, to.getBalance());
    }
}
