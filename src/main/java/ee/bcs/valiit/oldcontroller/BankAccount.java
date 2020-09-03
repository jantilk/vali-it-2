package ee.bcs.valiit.oldcontroller;

import java.math.BigDecimal;

public class BankAccount {
    String accountNr;
    String accountNr2;
    BigDecimal balance;
    BigDecimal transferAmount;

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getAccountNr2() {
        return accountNr2;
    }

    public void setAccountNr2(String accountNr2) {
        this.accountNr2 = accountNr2;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


}
