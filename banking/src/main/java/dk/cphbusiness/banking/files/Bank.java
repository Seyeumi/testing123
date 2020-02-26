package dk.cphbusiness.banking.files;

import java.util.Map;

public interface Bank {
  String getCvr();
  String getName();
  Account getAccount(int number);
  Map<Integer, Account> getAccounts(Customer customer);

  void addAccount(Account account);
}
