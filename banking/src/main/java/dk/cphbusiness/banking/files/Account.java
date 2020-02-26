package dk.cphbusiness.banking.files;

import java.util.List;

public interface Account {

    Bank getBank();

    Customer getCustomer();

    int getNumber();

    long getBalance();

    List<Movement> getWithdrawals();

    List<Movement> getDeposits();

    void setBalance(long amount);

    void transfer(long amount, Account target);

    void transfer(long amount, int targetNumber);
}