package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TransferTest {

    @ParameterizedTest
    @CsvSource({
            "5000,500,1000,true",
            "5000,500,5000,true",
            "5000,500,0,false",
            "5000,500,-100,false",
            "0,500,100,false"
    })
    public void AuditTransferTest(int from, int to, int amount, boolean expected) {
        Bank account = new Bank();

        boolean actual = account.transfer(from, to, amount);
        Assertions.assertEquals(expected, actual);
    }
}
