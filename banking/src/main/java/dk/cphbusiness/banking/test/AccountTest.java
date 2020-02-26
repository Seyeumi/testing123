package dk.cphbusiness.banking.test;

import dk.cphbusiness.banking.files.Account;
import dk.cphbusiness.banking.files.Bank;
import dk.cphbusiness.banking.files.Customer;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

  @Test
  public void testCreateAccount() throws Exception {
    Bank bank = new BankDummy("17299999","Glorious bank");
    Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
    Account account = new AccountDummy(bank, customer);
    assertNotNull(account);
    }

  @Test
  public void testCreateAccountWithBank() {
    Bank bank = new BankDummy("17299999","Glorious bank");
    Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
    Account account = new AccountDummy(bank, customer);
    assertEquals(bank, account.getBank());
    assertNotNull(account.getBank());
    }

  @Test
  public void testCreateAccountWithNumber() {
    Bank bank = new BankDummy("17299999","Glorious bank");
    Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
    int number = 0;
    Account account = new AccountDummy(bank, customer);
    assertEquals(number, account.getNumber());
    }

  @Test
  public void testCreateAccountWithZeroBalance() {
    Bank bank = new BankDummy("17299999","Glorious bank");
    Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
    Account account = new AccountDummy(bank, customer);
    assertEquals(0L, account.getBalance());
    }

  @Test
  public void testTransferPositiveAmount() {
    Bank bank = new BankDummy("17299999","Glorious bank");
    Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
    Account source = new AccountDummy(bank, customer);
    Account target = new AccountDummy(bank, customer);
    source.transfer(10000, target);
    assertEquals(-10000, source.getBalance());
    assertEquals(10000, target.getBalance());
    }

  @Test
  public void testTransferPositiveAmountUsingNumber() {
    Bank bank = new BankDummy("17299999","Glorious bank");
    Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
    Account target = new AccountDummy(bank, customer);
    Account source = new AccountDummy(bank, customer);
    bank.addAccount(source);
    bank.addAccount(target);
    source.transfer(10000, 1);
    assertEquals(-10000, source.getBalance());
    assertEquals(10000, target.getBalance());
    }

  }
