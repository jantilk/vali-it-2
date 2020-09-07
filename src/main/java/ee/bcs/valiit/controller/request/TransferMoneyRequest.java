package ee.bcs.valiit.controller.request;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TransferMoneyRequest {
    private BigInteger fromAccountId;
    private BigInteger toAccountId;
    private BigDecimal amount;

    public BigInteger getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(BigInteger fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public BigInteger getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(BigInteger toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
