package ee.bcs.valiit.controller;

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
        accountService.transferMoney(request.getFromAccount(),
                                    request.getToAccount(),
                                    request.getAmount());
    }

    @PutMapping("add")
    public void add(@RequestBody AddMoneyRequest request) {
        accountService.addMoney(request.getToAccount(),
                                request.getAmount());
    }

    @PutMapping("take")
    public void take(@RequestBody TakeMoneyRequest request) {
        accountService.takeMoney(request.getFromAccount(),
                                request.getAmount());
    }

    @GetMapping("balance/{account_number}")
    public BigDecimal balance(@PathVariable("account_number") String request) {
        return accountService.balanceCheck(request);
    }

    @GetMapping("accounts")
    public List<AccountsRequest> accounts() {
        return accountService.allAccounts();
    }

    @PostMapping("account/create")
    public void create(@RequestBody CreateAccountRequest request) {
        accountService.createAccount(request.getId(),
                                    request.getAccountNumber(),
                                    request.getBalance(),
                                    request.getCustomer_id());
    }

    // customer ************************************************************************************
    @PostMapping("customer/create")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request.getId(), request.getCustomerName());
    }

}
