package Part2.Server;

import Part2.Account;
import Part2.GraphService;
import Part2.NoCreditException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GraphServiceInvocationHandler implements InvocationHandler {
    private GraphService service;
    private Register register;

    public GraphServiceInvocationHandler(GraphService service, Register register) {
        this.service = service;
        this.register = register;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException, NoCreditException {
        Account a = (Account) args[0];

        //credit control
        if (!register.hasCredit(a))
            throw new NoCreditException();

        register.decreaseCredit(a);

        //print method invocation time
        synchronized (this) {
            System.out.println(method.getName() + " "
                    + "invoked at " + new SimpleDateFormat("hh:mm:ss").format(new Date()) + " "
                    + "(Account: " + a.getName() + ") (Credit left: " + register.getCredit(a) + ") "
                    + "(Thread " + Thread.currentThread().getId() + ")"
            );
        }

        //invoke method
        long t0 = System.nanoTime();
        Object retval = method.invoke(service, args);
        long t1 = System.nanoTime();

        //print runtime of the method
        synchronized (this) {
            System.out.println(method.getName() + " "
                    + "tooks " + String.format("%.3f", ((t1 - t0) * 1e-6)) + " ms" + " "
                    + "(Account: " + a.getName() + ") "
                    + "(Thread " + Thread.currentThread().getId() + ")"
            );
        }

        return retval;
    }
}
