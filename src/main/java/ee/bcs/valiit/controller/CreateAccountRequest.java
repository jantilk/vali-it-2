package ee.bcs.valiit.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CreateAccountRequest {
    BigInteger id;
    String accountNumber;
    BigDecimal balance;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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
