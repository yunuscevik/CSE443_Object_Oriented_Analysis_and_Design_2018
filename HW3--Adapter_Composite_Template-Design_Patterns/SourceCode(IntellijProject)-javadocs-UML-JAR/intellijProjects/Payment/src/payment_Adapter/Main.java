package payment_Adapter;

/**
 * Kredi karti odemeleri icin hangi adapterin kullanilacagi belirlenir.
 * Sirketin eski odeme bicimi olan TurboPayment'i ModernPayment'a adapte etmek icin adaptorlerin kullanildigi main sinifidir.
 * @author Yunus CEVIK
 */
public class Main {
    public static void main(String[] args) {
        TargetTurboPayment turbo = new TargetTurboPayment();
        ModernPayment modernPayment = new PaymentAdapterFromTurboToModern(turbo);

        String cardNoValue = "147258369";
        float amountValue  = 500;
        String destinationValue = "10";
        String installmentsValue = "Yes";

        System.out.println();
        modernPayment.pay(cardNoValue, amountValue, destinationValue, installmentsValue);
    }
}
