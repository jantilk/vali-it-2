package ee.bcs.valiit.controller.request;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AddMoneyRequest {
    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private BigInteger accountId;
    private BigDecimal amount;


}
