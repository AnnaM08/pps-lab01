import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {
//Evitare magic number e codice duplicato nei test
    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private final double STARTING_BALANCE = 0;
    private final int NOT_DEFINED_ID = 2;
    private final double DEPOSITED_VALUE = 100;
    private final double WITHDRAW_VALUE = 70;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, STARTING_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(STARTING_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        //boolean depositedMoney = 100;
        bankAccount.deposit(accountHolder.id(), DEPOSITED_VALUE);
        assertEquals(DEPOSITED_VALUE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSITED_VALUE);
        bankAccount.deposit(NOT_DEFINED_ID, 50);
        assertEquals(DEPOSITED_VALUE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee() {
        bankAccount.deposit(accountHolder.id(), DEPOSITED_VALUE);
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_VALUE);
        assertEquals(DEPOSITED_VALUE - WITHDRAW_VALUE - SimpleBankAccount.FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.id(), DEPOSITED_VALUE);
        bankAccount.withdraw(NOT_DEFINED_ID, WITHDRAW_VALUE);
        assertEquals(DEPOSITED_VALUE, bankAccount.getBalance());
    }
}
