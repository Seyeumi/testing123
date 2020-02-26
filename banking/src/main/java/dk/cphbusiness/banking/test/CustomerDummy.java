package dk.cphbusiness.banking.test;

import dk.cphbusiness.banking.files.Account;
import dk.cphbusiness.banking.files.Bank;
import dk.cphbusiness.banking.files.Customer;
import dk.cphbusiness.banking.files.Movement;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDummy implements Customer {
  private String cpr;
  private String name;
  private Bank bank;
  Map<Integer, Account> accounts = new HashMap<>();

  public CustomerDummy(String cpr, String name, Bank bank) {
    this.cpr = cpr;
    this.name = name;
    this.bank = bank;
  }

  @Override
  public String getCpr() {
    return cpr;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Bank getBank() {
    return bank;
  }

  @Override
  public Map<Integer, Account> getAccounts() {
    return accounts;
  }

  @Override
  public List<Movement> getListOfWithdrawal(int number) {
    return accounts.get(number).getWithdrawals();
  }

  @Override
  public List<Movement> getListOfDeposits(int number) {
    return accounts.get(number).getDeposits();
  }

  @Override
  public void transfer(int amount, Account account, Account targetAccount) {
    Account fromAccount = accounts.get(account.getNumber());
    Account toAccount = bank.getAccount(targetAccount.getNumber());
    fromAccount.setBalance(fromAccount.getBalance() - amount);
    toAccount.setBalance(toAccount.getBalance() + amount);
    Movement movement = new MovementDummy(LocalDateTime.now(), amount);
    fromAccount.getWithdrawals().add(movement);
    toAccount.getDeposits().add(movement);
  }
}
