import models.Account;
import models.Bank;
import models.Customer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountMockingTest {

    @Mock
    Customer customer;

    @Mock
    Bank mockedBank;

    @Test
    public void testAccountTransferWithAccount() {
        final String targetNumber = "TGT54321";
        Account source = new AccountDummy(mockedBank, customer, "SRC54321");
        Account target = new AccountDummy(mockedBank, customer, targetNumber);

        source.transfer(10000, target);
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());

        //context.assertIsSatisfied();
    }

    @Test
    public void testAccountTransferWithNumber() {
        final String targetNumber = "TGT54321";
        Account source = new AccountDummy(mockedBank, customer, "SRC54321");
        Account target = new AccountDummy(mockedBank, customer, targetNumber);
        when(mockedBank.getAccount(targetNumber)).thenReturn(target);

        source.transfer(10000, "TGT54321");
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
    }



}