package pl.PBur27.creditcard;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAssignsCredit() {
        // Arrange
        CreditCard card = new CreditCard();
        // Act
        card.assignCredit(BigDecimal.valueOf(1000));
        // Assert
        assertEquals(
                BigDecimal.valueOf(1000),
                card.getBalance()
        );
    }

    @Test
    void itAssignsCreditV2() {
        // Arrange
        CreditCard card = new CreditCard();
        // Act
        card.assignCredit(BigDecimal.valueOf(1500));
        // Assert
        assert BigDecimal.valueOf(1500).equals(card.getBalance());
    }

    @Test
    void itDeniesCreditBelowThresholdV1() {
        var card = new CreditCard();

        try {
            card.assignCredit(BigDecimal.valueOf(50));
            assert false;
        } catch (CreditBelowThresholdException e) {
            assert true;
        }
    }

    @Test
    void itDeniesCreditBelowThresholdV2() {
        var card = new CreditCard();
        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10))
        );
    }

    @Test
    void itDeniesCreditReassignment() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(CreditReassignmentException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1200)));
    }

    @Test
    void itDeniesInsufficientFunds() {
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(NotEnoughMoneyException.class, () -> card.pay(BigDecimal.valueOf(1100)));
    }

    @Test
    void itAllowsToPayForSomething() {
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        card.pay(BigDecimal.valueOf(900));
        assertEquals(
                card.getBalance(),
                BigDecimal.valueOf(100)
        );
    }
    // AssertJ
}
