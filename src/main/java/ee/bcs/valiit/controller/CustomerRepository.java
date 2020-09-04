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


    public void createCustomer(BigInteger id, String customerName) {
        String sql = "INSERT INTO customer (id, customer_name) VALUES (:id, :customerName)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("customerName", customerName);
        jdbcTemplate.update(sql, paramMap);
    }
}
