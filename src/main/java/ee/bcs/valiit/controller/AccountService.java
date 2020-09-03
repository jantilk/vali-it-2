package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    public void transferMoney(String fromAccount,
                              String toAccount,
                              BigDecimal amount) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccount);
        if(fromAccountBalance.compareTo(amount) >= 0){
            BigDecimal toAccountBalance = accountRepository.getBalance(toAccount);
            fromAccountBalance = fromAccountBalance.subtract(amount);
            toAccountBalance = toAccountBalance.add(amount);
            accountRepository.updateBalance(fromAccount, fromAccountBalance);
            accountRepository.updateBalance(toAccount, toAccountBalance);
        }
    }


    public void addMoney(String toAccount, BigDecimal amount) {
        BigDecimal toAccountBalance = accountRepository.getBalance(toAccount);
        toAccountBalance = toAccountBalance.add(amount);
        accountRepository.updateBalance(toAccount, toAccountBalance);
    }


    public void takeMoney(String fromAccount, BigDecimal amount) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccount);
        if (fromAccountBalance.compareTo(amount) >= 0) {
            fromAccountBalance = fromAccountBalance.subtract(amount);
            accountRepository.updateBalance(fromAccount, fromAccountBalance);
        }
    }


    public BigDecimal balanceCheck(String fromAccount) {
        return accountRepository.getBalance(fromAccount);
    }


    public List<AccountsRequest> allAccounts() {
        return accountRepository.getAccounts();
    }

    public void createAccount(BigInteger id, String accountNumber, BigDecimal balance) {
        accountRepository.createAccount(id, accountNumber, balance);
    }
}

