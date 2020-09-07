package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public void createCustomer(String customerName) {
        customerRepository.createCustomer(customerName);
    }

    public void deleteCustomer(BigInteger id) {
        customerRepository.deleteCustomer(id);
    }

}
