package dk.cphbusiness.banking.test;

import dk.cphbusiness.banking.files.*;

import java.time.LocalDateTime;
import java.util.List;

public class AccountDummy implements Account {

    private Bank bank;
    private Customer customer;
    private int number;
    private long balance = 0;
    private List<Movement> withdrawals;
    private List<Movement> deposits;

    public AccountDummy(Bank bank, Customer customer) {
        this.bank = bank;
        this.customer = customer;
        this.number = Utils.accountAmount;
        Utils.accountAmount++;
    }

    @Override
    public Bank getBank() {
        return bank;
    }
    @Override
    public Customer getCustomer() {
        return customer;
    }
    @Override
    public int getNumber() {
        return number;
    }
    @Override
    public long getBalance() {
        return balance;
    }
    @Override
    public List<Movement> getWithdrawals() {
        return withdrawals;
    }
    @Override
    public List<Movement> getDeposits() {
        return deposits;
    }

    @Override
    public void setBalance(long amount) {
        this.balance = amount;
    }

    public void transfer(long amount, Account target) {
        this.balance -= amount;
        target.setBalance(target.getBalance() + amount);
        Movement movement = new MovementDummy(LocalDateTime.now(), amount);
        withdrawals.add(movement);
        target.getDeposits().add(movement);
    }

    public void transfer(long amount, int targetNumber) {
        Account target = bank.getAccount(targetNumber);
        transfer(amount, target);
    }
}
