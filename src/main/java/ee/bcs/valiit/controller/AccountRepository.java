package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
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

    public void updateBalance(String fromAccount, BigDecimal fromAccountBalance) {
        String sql = "UPDATE account SET balance = :balance " +
                "WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("balance", fromAccount);
        paramMap.put("accountNumber", fromAccountBalance);
        jdbcTemplate.update(sql, paramMap);
    }
}
