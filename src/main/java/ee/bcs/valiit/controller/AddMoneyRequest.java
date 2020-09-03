package ee.bcs.valiit.controller;

import java.math.BigDecimal;

public class AddMoneyRequest {
    private String toAccount;
    private BigDecimal amount;

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
