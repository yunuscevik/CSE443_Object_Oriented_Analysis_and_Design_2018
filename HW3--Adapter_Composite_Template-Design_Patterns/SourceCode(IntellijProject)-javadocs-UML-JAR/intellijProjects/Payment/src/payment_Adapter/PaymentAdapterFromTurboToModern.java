package payment_Adapter;

/**
 * TurboPayment'i ModernPayment arayuzune donduren adapter.
 * @author Yunus CEVIK
 */
public class PaymentAdapterFromTurboToModern implements ModernPayment{

    private TurboPayment turboPayment;

    /**
     * TurboPayment'tan ModernPayment'a donusumun yapilacagi sinifin kurucu fonksiyonudur.
     * @param turboPayment TurboPayment tipinde parametre alir.
     */
    public PaymentAdapterFromTurboToModern(TurboPayment turboPayment){
        this.turboPayment = turboPayment;
    }

    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("Adapter (TurboPayment -> ModernPayment)");
        System.out.println("---- Modern Payment ----");
        System.out.println("Card No: "+ cardNo + "\nDestination :" + destination + "\nInstallments :" + installments);
        return turboPayment.payInTurbo(cardNo, amount, destination, installments);
    }
}
