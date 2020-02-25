package dk.cphbusiness.banking;

public class RealBank implements Bank {
    private String cvr;
    private String name;

    public RealBank(String cvr, String name) {
        this.cvr = cvr;
        this.name = name;
    }



    @Override
    public Account getAccount(String number) {
        return null;
    }

    @Override
    public Account getAccounts(Customer customer) {
        return null;
    }
}
