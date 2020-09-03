package old.BankController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
public class BankController {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    Map<String, BankAccount> bankAccounts = new HashMap<>();

    @GetMapping("sql/test")
    public String testSql() {
        String sql = "SELECT account_nr FROM customer WHERE id = :id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", 1);
        String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return vastus;
    }
    @GetMapping("sql/test2")
    public List<Account> testsql2() {
        String sql = "SELECT * FROM account";
        Map paramMap = new HashMap();
        List<Account> accounts = jdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return accounts;
    }

    // create
    @PostMapping("sql/create")
    public void sqlCreate() {
        String sql = "INSERT INTO account (id, account_nr) VALUES (:id, :account_nr)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", 2);
        paramMap.put("account_nr", "US999");
        jdbcTemplate.update(sql, paramMap);
    }

    // balance set
    @PutMapping("sql/balance")
    public void sqlBalance() {
        String sql = "UPDATE account SET balance = :balance WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 1);
        paramMap.put("balance", 50);
        jdbcTemplate.update(sql, paramMap);
    }

    // transfer
    @PutMapping("sql/transfer")
    public void sqlTransfer() {
        String sqlSelect = "SELECT balance FROM account WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 1);
        BigDecimal account1Balance = jdbcTemplate.queryForObject(sqlSelect, paramMap, BigDecimal.class);
        paramMap = new HashMap<>();
        paramMap.put("id", 2);
        BigDecimal account2Balance = jdbcTemplate.queryForObject(sqlSelect, paramMap, BigDecimal.class);

        // calculate
        BigDecimal transferAmount = BigDecimal.valueOf(50);
        account1Balance = account1Balance.subtract(transferAmount);
        account2Balance = account2Balance.add(transferAmount);

        // 2x update
        String sqlUpdate = "UPDATE account SET balance = :balance WHERE id = :id";
        paramMap = new HashMap<>();
        paramMap.put("id", 2);
        paramMap.put("balance", account2Balance);
        jdbcTemplate.update(sqlUpdate, paramMap);
        paramMap = new HashMap<>();
        paramMap.put("id", 1);
        paramMap.put("balance", account1Balance);
        jdbcTemplate.update(sqlUpdate, paramMap);
    }

    @PutMapping("bank/deposit")
    public void deposit(@RequestBody() BankAccount deposit) {
        String sisendKontoNumber = deposit.getAccountNr();
        BigDecimal sisendPaljuRahaJuurde = deposit.getBalance();

        BankAccount praegunePangaKontoSeis = bankAccounts.get(sisendKontoNumber);
        BigDecimal hetkeRahaJääk = praegunePangaKontoSeis.getBalance();

        BigDecimal rahaKokku = hetkeRahaJääk.add(sisendPaljuRahaJuurde);
        praegunePangaKontoSeis.setBalance(rahaKokku);
        bankAccounts.put(sisendKontoNumber, praegunePangaKontoSeis);
    }

    @PutMapping("bank/credit")
    public void credit(@RequestBody() BankAccount credit) {
        String inputAccount = credit.getAccountNr();
        BigDecimal moneyOut = credit.getBalance();

        BankAccount currentAccountBalance = bankAccounts.get(inputAccount);
        BigDecimal currentBalance = currentAccountBalance.getBalance();

        BigDecimal finalBalance = currentBalance.subtract(moneyOut);
        currentAccountBalance.setBalance(finalBalance);
        bankAccounts.put(inputAccount, currentAccountBalance);
    }

    @PutMapping("bank/transfer")
    public void transfer(@RequestBody() BankAccount transfer) {
        BigDecimal takeAccountBalance = bankAccounts.get(transfer.accountNr).getBalance();
        BigDecimal putAccountBalance = bankAccounts.get(transfer.accountNr2).getBalance();
        BigDecimal transferAmount = transfer.getTransferAmount();

        BigDecimal takeFinal = takeAccountBalance.subtract(transferAmount);
        BigDecimal putFinal = putAccountBalance.add(transferAmount);

        bankAccounts.get(transfer.accountNr).setBalance(takeFinal);
        bankAccounts.get(transfer.accountNr2).setBalance(putFinal);

        bankAccounts.put(transfer.accountNr, bankAccounts.get(transfer.accountNr));
        bankAccounts.put(transfer.accountNr2, bankAccounts.get(transfer.accountNr2));
    }

}
