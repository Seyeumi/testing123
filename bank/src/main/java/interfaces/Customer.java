package models;

import java.util.List;
import java.util.Map;

public interface Customer {
    public void transfer(int amount, Account account, Account targetAccount);
    public String getCpr();
    public String getName();
    public Bank getBank();
    public Map<Integer, Account> getAccounts();

    public List<Movement> getListOfWithdrawal(int number);
    public List<Movement> getListOfDeposits(int number);
}

