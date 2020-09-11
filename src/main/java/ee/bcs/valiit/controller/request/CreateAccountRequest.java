package ee.bcs.valiit.controller.request;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CreateAccountRequest {
    String accountNumber;
    BigDecimal balance;
    BigDecimal customerId;

    public BigDecimal getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigDecimal customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
