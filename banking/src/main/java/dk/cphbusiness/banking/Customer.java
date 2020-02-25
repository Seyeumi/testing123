package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface Customer {
    public void transfer(int amount, Account account, Customer targetcustomer, Account targetacc);
    public String getCpr();
    public Map<Integer, Account> getAccounts();
    public Account getAcc();
}

