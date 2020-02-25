package dk.cphbusiness.banking;

import java.util.HashMap;
import java.util.Map;

public class BankDummy implements Bank {
  private String cvr;
  private String name;

  Map<String, Customer> customers = new HashMap<>();
  Map<Integer, Account> allAccounts = new HashMap<>();

  public BankDummy(String cvr, String name) {
    this.cvr = cvr;
    this.name = name;

  }

  @Override
  public Account getAccount(int number) throws Exception {
    Account acc = null;
    for (Map.Entry<String, Customer> entries: customers.entrySet())
    {
      if(entries.getValue().getAccounts().containsKey(number))
      {
        acc = entries.getValue().getAccounts().get(number);
      }
    }
    if (acc == null)
      throw new Exception("Account does not exist");

    return acc;
  }


  @Override
  public Map<Integer, Account> getAccounts(Customer customer) {
    return customers.get(customer.getCpr()).getAccounts();
  }
}

