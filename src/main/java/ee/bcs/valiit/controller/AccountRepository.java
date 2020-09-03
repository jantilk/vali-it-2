package ee.bcs.valiit.controller;

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


    public BigDecimal getBalance(String account) {
        String sql = "SELECT balance FROM account " +
                "WHERE account_number = :accountNumber";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accountNumber", account);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public void updateBalance(String account, BigDecimal accountBalance) {
        String sql = "UPDATE account SET balance = :balance " +
                "WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("balance", accountBalance);
        paramMap.put("accountNumber", account);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<AccountsRequest> getAccounts() {
        String sql = "SELECT * FROM account";
        List<AccountsRequest> accountsRequests = jdbcTemplate.query(sql, new HashMap<>(), new AccountRowMapper());
        return accountsRequests;
    }

    public void createAccount(BigInteger id, String accountNumber, BigDecimal balance) {
        String sql = "INSERT INTO account (id, account_number, balance) " +
                    "VALUES (:id, :accountNumber, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", balance);
        jdbcTemplate.update(sql, paramMap);
    }
}
