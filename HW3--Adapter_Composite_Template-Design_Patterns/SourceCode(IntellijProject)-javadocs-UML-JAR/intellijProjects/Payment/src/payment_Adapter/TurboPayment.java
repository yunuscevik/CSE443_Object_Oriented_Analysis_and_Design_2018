package payment_Adapter;

/**
 * Kredi karti odemeleri icin eski arayuz.
 * @author Yunus CEVIK
 */
public interface TurboPayment {
    /**
     * payInTurbo ile eski yapida olan kredi karti odemesi yapan metot.
     * @param turboCardNo Kart numarasi
     * @param turboAmount Miktari
     * @param destinationTurboOfCourse Hedefi
     * @param installmentsButInTurbo Taksiti
     * @return Miktarinin return degeri
     */
    int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo);
}