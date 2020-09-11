package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.request.*;
import ee.bcs.valiit.controller.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
public class BankController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // accounts *********************************************************************************
    @PutMapping("transfer")
    public void transfer(@RequestBody TransferMoneyRequest request) {
        accountService.transferMoney(request.getFromAccountId(),
                                    request.getToAccountId(),
                                    request.getAmount());
    }

    @PutMapping("add")
    public BigDecimal add(@RequestBody AddMoneyRequest request) {
        accountService.addMoney(request.getAccountId(), request.getAmount());
        return accountService.balanceCheck(request.getAccountId());
    }

    @PutMapping("take")
    public void take(@RequestBody TakeMoneyRequest request) {
        accountService.takeMoney(request.getAccountId(), request.getAmount());
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
                request.getCustomerId());
    }

    // customer ************************************************************************************
    @PostMapping("customer/create")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request.getCustomerName(),
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()));
    }

}
