package ee.bcs.valiit.controller.request;

import java.math.BigInteger;

public class CreateCustomerRequest {
    BigInteger id;
    String customerName;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
