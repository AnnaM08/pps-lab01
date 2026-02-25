package example.model;

public class SimpleBankAccountWithFee extends SimpleBankAccount{

    public final static double FEE = 1;

    public SimpleBankAccountWithFee(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        final double amountWithFee = amount + FEE;
        super.withdraw(userID, amountWithFee);
    }

}
