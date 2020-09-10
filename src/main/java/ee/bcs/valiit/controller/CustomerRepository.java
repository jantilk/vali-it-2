package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void createCustomer(String customerName, String username, String password) {
        String sql = "INSERT INTO customer (customer_name, username, password) VALUES (:customerName, :username, :password)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("customerName", customerName);
        paramMap.put("username", username);
        paramMap.put("password", password);
        jdbcTemplate.update(sql, paramMap);
    }

    public void deleteCustomer(BigInteger id) {
        String sql = "DELETE FROM customer WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbcTemplate.update(sql, paramMap);
    }
}
