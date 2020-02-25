package dk.cphbusiness.banking;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDummy implements Customer {
  private String cpr;
  private String name;
  private Bank bank;
  Map<Integer, Account> accounts = new HashMap<>();

  @Override
  public String getCpr() {
    return cpr;
  }

  public String getName() {
    return name;
  }

  public Bank getBank() {
    return bank;
  }

  @Override
  public Map<Integer, Account> getAccounts() {
    return accounts;
  }


  public CustomerDummy(String cpr, String name, Bank bank) {
    this.cpr = cpr;
    this.name = name;
    this.bank = bank;
  }


  @Override
  public void transfer(int amount, Account account, Customer targetcustomer, Account targetacc) {

  }
}
