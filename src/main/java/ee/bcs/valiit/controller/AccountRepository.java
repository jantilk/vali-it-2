package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.request.AccountRowMapper;
import ee.bcs.valiit.controller.request.AccountsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public BigDecimal getBalance(BigInteger accountId) {
        String sql = "SELECT balance FROM account " +
                "WHERE id = :accountId";
        Map<String, BigInteger> paramMap = new HashMap<>();
        paramMap.put("accountId", accountId);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public void updateBalance(BigInteger accountId, BigDecimal accountBalance) {
        String sql = "UPDATE account SET balance = :balance WHERE id = :accountId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("balance", accountBalance);
        paramMap.put("accountId", accountId);
        jdbcTemplate.update(sql, paramMap);
    }

    public void updateTransactionHistory(BigDecimal amount, BigInteger accountId) {
        String sql = "INSERT INTO transaction_history (amount, account_id) VALUES (:amount, :accountId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("amount", amount);
        paramMap.put("accountId", accountId);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<AccountsRequest> getAccounts() {
        String sql = "SELECT * FROM account";
        List<AccountsRequest> accountsRequests = jdbcTemplate.query(sql, new HashMap<>(), new AccountRowMapper());
        return accountsRequests;
    }

    public void createAccount(String accountNumber, BigDecimal balance) {
        String sql = "INSERT INTO account (account_number, balance) " +
                    "VALUES (:accountNumber, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", balance);
        jdbcTemplate.update(sql, paramMap);
    }

}
