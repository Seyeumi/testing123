package dk.cphbusiness.banking.test;

import dk.cphbusiness.banking.files.Account;
import dk.cphbusiness.banking.files.Bank;
import dk.cphbusiness.banking.files.Customer;

import java.util.HashMap;
import java.util.Map;

public class BankDummy implements Bank {
  private String cvr;
  private String name;

  Map<String, Customer> customers = new HashMap<>();
  Map<Integer, Account> accounts = new HashMap<>();

  public BankDummy(String cvr, String name) {
    this.cvr = cvr;
    this.name = name;
  }

  public String getCvr() {
    return cvr;
  }

  public String getName() {
    return name;
  }

  @Override
  public Account getAccount(int number) {
    return accounts.get(number);
  }

  @Override
  public Map<Integer, Account> getAccounts(Customer customer) {
    return accounts;
  }

  @Override
  public void addAccount(Account account) {
    accounts.put(account.getNumber(), account);
  }

}

