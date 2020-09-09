package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.repository.Customer2;
import ee.bcs.valiit.controller.repository.Customer2Repository;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Customer2Repository customer2Repository;


    public void createCustomer(String customerName) {
        Customer2 customer = new Customer2();
        customer.setCustomerName(customerName);
        customer2Repository.save(customer);
    }

}
