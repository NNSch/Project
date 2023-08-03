package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BankTest {

    @Test
    public void transferValidBalance() {
        Account from = mock(Account.class);
        Account to = mock(Account.class);
        int amount = 500;

        when(from.getBalance()).thenReturn(1000);
        when(from.pay(amount)).thenReturn(true);
        when(to.getBalance()).thenReturn(500);

        Bank bank = new Bank();
        assertTrue(bank.transfer(from, to, amount));

        verify(from).pay(amount);
        verify(to).add(amount);
    }

    @Test
    public void transferInvalidBalance() {
        Account from = mock(Account.class);
        Account to = mock(Account.class);
        int amount = 800;

        when(from.getBalance()).thenReturn(500);
        when(to.getBalance()).thenReturn(500);

        Bank bank = new Bank();
        assertFalse(bank.transfer(from, to, amount));

        }

    @Test
    public void transferNegativeAmount() {
        Account from = mock(Account.class);
        Account to = mock(Account.class);
        int amount = -200;

        Bank bank = new Bank();
        assertFalse(bank.transfer(from, to, amount));

        verify(from, never()).pay(amount);
        verify(to, never()).add(amount);
    }

    @Test
    public void transferZeroAmount() {
        Account from = mock(Account.class);
        Account to = mock(Account.class);
        int amount = 0;

        Bank bank = new Bank();
        assertFalse(bank.transfer(from, to, amount));

        verify(from, never()).pay(amount);
        verify(to, never()).add(amount);
    }
}

