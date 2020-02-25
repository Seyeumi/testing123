package dk.cphbusiness.banking;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BankTest {

    @Test
    public void testCreateBank() throws Exception {
        Bank bank = new BankDummy("17288888", "Glorious bank");
        assertNotNull(bank);
    }

    @Test
    public void testBankTransfer() throws Exception {
        Bank bank = new BankDummy("17288888", "Glorious bank");
        Customer cust = new CustomerDummy("123", "Kat", bank);



    }
}
