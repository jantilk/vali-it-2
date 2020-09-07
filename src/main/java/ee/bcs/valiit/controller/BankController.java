package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
public class BankController {
    @Autowired
    private AccountService accountService;


    private AccountRepository accountRepository;

    @Autowired
    private CustomerService customerService;

    private CustomerRepository customerRepository;


    // accounts *********************************************************************************
    @PutMapping("transfer")
    public void transfer(@RequestBody TransferMoneyRequest request) {
        accountService.transferMoney(request.getFromAccountId(),
                                    request.getToAccountId(),
                                    request.getAmount());
    }

    @PutMapping("add")
    public void add(@RequestBody AddMoneyRequest request) {
        accountService.addMoney(request.getAccountId(),
                                request.getAmount());
    }

    @PutMapping("take")
    public void take(@RequestBody TakeMoneyRequest request) {
        accountService.takeMoney(request.getAccountId(),
                                request.getAmount());
    }

    @GetMapping("balance/{account_number}")
    public BigDecimal balance(@PathVariable("account_number") BigInteger request) {
        return accountService.balanceCheck(request);
    }

    @GetMapping("accounts")
    public List<AccountsRequest> accounts() {
        return accountService.allAccounts();
    }

    @PostMapping("account/create")
    public void create(@RequestBody CreateAccountRequest request) {
        accountService.createAccount(request.getAccountNumber(),
                                    request.getBalance(),
                                    request.getCustomer_id());
    }

    @DeleteMapping("account/delete/{id}")
    public void deleteAccount(@PathVariable("id") BigInteger id) {
        accountService.deleteAccount(id);
    }

    // customer ************************************************************************************
    @PostMapping("customer/create")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request.getCustomerName());
    }

    @DeleteMapping("customer/delete/{id}")
    public void deleteCustomer(@PathVariable("id") BigInteger id) {
        customerService.deleteCustomer(id);
    }

}
