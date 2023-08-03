package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void constructorInvalidParameters() {
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(-1000, 3000, 1000, 5));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(3000, -1000, 5000, 5));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(3000, 1000, -5000, 5));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2000, 3000, 1000, 5));
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(3000, 1000, 5000, -5));
    }

    @Test
    public void addValidAmount() {
        SavingAccount savingAccount = new SavingAccount(2000, 1000, 6000, 10);
        assertTrue(savingAccount.add(1000));
        assertEquals(3000, savingAccount.getBalance());
    }
    @Test
    public void addMaxValidAmount() {
        SavingAccount savingAccount = new SavingAccount(2000, 1000, 6000, 10);
        assertTrue(savingAccount.add(4000));
        assertEquals(6000, savingAccount.getBalance());
    }

    @Test
    public void addInvalidAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertFalse(savingAccount.add(3000));
        assertEquals(3000, savingAccount.getBalance());
    }

    @Test
    public void addNegativeAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertFalse(savingAccount.add(-1000));
        assertEquals(3000, savingAccount.getBalance());
    }

    @Test
    public void payValidAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertTrue(savingAccount.pay(1000));
        assertEquals(2000, savingAccount.getBalance());
    }
    @Test
    public void payValidAmountMin() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertTrue(savingAccount.pay(2000));
        assertEquals(1000, savingAccount.getBalance());
    }


    @Test
    public void payInvalidAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertFalse(savingAccount.pay(2500));
        assertEquals(3000, savingAccount.getBalance());
    }

    @Test
    public void payNegativeAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertFalse(savingAccount.pay(-500));
        assertEquals(3000, savingAccount.getBalance());
    }

    @Test
    public void yearChange() {
        SavingAccount savingAccount = new SavingAccount(200, 0, 5000, 15);
        double interest = savingAccount.yearChange();
        assertEquals(30, interest);
    }

}