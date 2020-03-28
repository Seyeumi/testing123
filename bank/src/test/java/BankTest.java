import models.Bank;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BankTest {

    @Test
    public void testCreateBank() throws Exception {
        Bank bank = new BankDummy("17288888", "Glorious bank");
        assertNotNull(bank);
    }


}
