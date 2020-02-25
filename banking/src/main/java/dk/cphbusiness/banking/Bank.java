package dk.cphbusiness.banking;

import java.util.List;
import java.util.Map;

public interface Bank {
  Account getAccount(int number) throws Exception;
  Map<Integer, Account> getAccounts(Customer customer);
}
