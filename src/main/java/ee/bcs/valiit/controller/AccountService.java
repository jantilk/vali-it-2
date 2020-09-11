package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.repository.AccountRepository;
import ee.bcs.valiit.controller.request.AccountsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    public void transferMoney(BigInteger fromAccountId,
                              BigInteger toAccountId,
                              BigDecimal amount) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccountId);
        if(fromAccountBalance.compareTo(amount) >= 0){
            BigDecimal toAccountBalance = accountRepository.getBalance(toAccountId);
            fromAccountBalance = fromAccountBalance.subtract(amount);
            toAccountBalance = toAccountBalance.add(amount);
            accountRepository.updateBalance(fromAccountId, fromAccountBalance);
            accountRepository.updateBalance(toAccountId, toAccountBalance);
            accountRepository.updateTransactionHistory(amount.negate(), fromAccountId);
            accountRepository.updateTransactionHistory(amount, toAccountId);
        }
    }


    public BigDecimal addMoney(BigInteger accountId, BigDecimal amount) {
        BigDecimal toAccountBalance = accountRepository.getBalance(accountId);
        toAccountBalance = toAccountBalance.add(amount);
        accountRepository.updateBalance(accountId, toAccountBalance);
        accountRepository.updateTransactionHistory(amount, accountId);
        return accountRepository.getBalance(accountId);

    }


    public void takeMoney(BigInteger accountId, BigDecimal amount) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(accountId);
        if (fromAccountBalance.compareTo(amount) >= 0) {
            fromAccountBalance = fromAccountBalance.subtract(amount);
            accountRepository.updateBalance(accountId, fromAccountBalance);
            accountRepository.updateTransactionHistory(amount.negate(), accountId);
        }
    }


    public BigDecimal balanceCheck(BigInteger accountId) {
        return accountRepository.getBalance(accountId);
    }


    public List<AccountsRequest> allAccounts() {
        return accountRepository.getAccounts();
    }

    public void createAccount(String accountNumber, BigDecimal balance, BigDecimal customerId) {
        accountRepository.createAccount(accountNumber, balance, customerId);
    }
}

