package pl.PBur27.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditLimit;
    private BigDecimal balance;

    void assignCredit(BigDecimal creditLimit) {
        if (isCreditReassigned()) {
            throw new CreditReassignmentException();
        }

        if (isCreditBelowThreshold(creditLimit)) {
            throw new CreditBelowThresholdException();
        }

        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }

    private boolean isCreditReassigned() {
        return creditLimit != null;
    }

    private static boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    public BigDecimal getBalance() {
        return balance;
    } // Or cardLimit?

    public void pay(BigDecimal money) {
        if (this.balance.subtract(money).compareTo(BigDecimal.ZERO) < 0) {
            throw new NotEnoughMoneyException();
        }

        this.balance = this.balance.subtract(money);
    }
}
