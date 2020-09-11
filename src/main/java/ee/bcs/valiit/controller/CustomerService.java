package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(String customerName, String username, String password) {
        customerRepository.createCustomer(customerName, username, password);
    }

}