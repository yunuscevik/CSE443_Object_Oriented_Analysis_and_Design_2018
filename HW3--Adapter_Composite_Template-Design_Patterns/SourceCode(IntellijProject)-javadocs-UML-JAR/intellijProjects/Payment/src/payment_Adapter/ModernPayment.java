package payment_Adapter;

/**
 * Kredi karti odemeleri icin olusturulmus yeni arayuz.
 * @author Yunus CEVIK
 */
public interface ModernPayment{
    /**
     * pay ile yeni yapida olan kredi karti odemesi yapan metot.
     * @param cardNo Kart numarasi
     * @param amount Miktari
     * @param destination Hedefi
     * @param installments Taksiti
     * @return Miktarinin return degeri
     */
    int pay(String cardNo, float amount, String destination, String installments);
}