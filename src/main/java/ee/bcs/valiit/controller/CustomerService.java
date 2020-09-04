package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public void createCustomer(BigInteger id, String customerName) {
        customerRepository.createCustomer(id, customerName);
    }
}
