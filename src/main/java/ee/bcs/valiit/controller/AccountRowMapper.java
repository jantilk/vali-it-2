package ee.bcs.valiit.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<AccountsRequest> {

    @Override
    public AccountsRequest mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountsRequest accountsList = new AccountsRequest();
        accountsList.setAccountNumber(resultSet.getString("account_number"));
        accountsList.setBalance(resultSet.getBigDecimal("balance"));
        accountsList.setId(resultSet.getLong("id"));
        return accountsList;
    }

}
