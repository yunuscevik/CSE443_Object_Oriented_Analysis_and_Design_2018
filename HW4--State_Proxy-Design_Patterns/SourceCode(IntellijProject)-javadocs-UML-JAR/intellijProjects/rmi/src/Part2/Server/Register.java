package Part2.Server;
import Part2.Account;
import Part2.RegistrationService;

import java.util.HashMap;
import java.util.Map;

public class Register implements RegistrationService {
    private Map<Account, Integer> accounts; //account -> credit

    public Register() {
        accounts = new HashMap<>();
    }

    @Override
    public synchronized int getCredit(Account a) {
        Integer credit = accounts.get(a);
        if (credit == null)
            return 0;
        return credit;
    }


    public synchronized boolean hasCredit(Account a) {
        return getCredit(a) > 0;
    }

    public synchronized void decreaseCredit(Account a) {
        if (accounts.containsKey(a))
            setCredit(a, getCredit(a) - 1);
    }

    public synchronized void setCredit(Account a, int credit) {
        accounts.replace(a, credit);
    }

    @Override
    public synchronized boolean register(Account a, int credit) {
        if (accounts.containsKey(a))
            return false;
        accounts.put(a, credit);
        return true;
    }

    @Override
    public synchronized boolean loadCredit(Account a, int credit) {
        if (!accounts.containsKey(a))
            return false;
        setCredit(a, accounts.get(a) + credit);
        return true;
    }
    @Override
    public synchronized String printAccounts(){
        String retVal = "";
        for ( Account key : accounts.keySet() ) {
            retVal += "UserName: "+ key.getName() + "  Credit No: " + key.getCreditCard()+ "  Credit: " + getCredit(key) + "\n";
        }
        return  retVal;
    }
}
