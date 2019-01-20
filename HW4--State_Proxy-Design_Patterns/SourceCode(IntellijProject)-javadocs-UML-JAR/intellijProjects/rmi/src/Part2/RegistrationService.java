package Part2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegistrationService extends Remote {
    /**
     * register new account
     * @param a account
     * @param credit credit
     * @return true on success, false otherwise
     * @throws RemoteException
     */
    boolean register(Account a, int credit) throws RemoteException;

    /**
     * account.credit = account.credit + credit
     * @param a account
     * @param credit credit
     * @return true on success, false otherwise
     * @throws RemoteException
     */
    boolean loadCredit(Account a, int credit) throws RemoteException;

    int getCredit(Account a) throws RemoteException;

    String printAccounts() throws RemoteException;
}
