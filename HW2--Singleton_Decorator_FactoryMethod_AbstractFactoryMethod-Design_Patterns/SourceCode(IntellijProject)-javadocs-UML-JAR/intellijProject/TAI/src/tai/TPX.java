package tai;

/**
 * TAI' de uretilen TPX tipinde modelidir. TAIPlanesStore' dan turetilir.
 * @author Yunus CEVIK
 */
public class TPX extends TAIPlanesStore{
    /**
     * TPX ucak modelinde farkli farkli serilerde de ucak uretimi gerceklestirilebilir.
     * @param item Uretilecek ucak tipini belirten parametre.
     * @return Uretilecek ucak modelinin olusturulmasi ve return edilmesi.
     */
    @Override
    Plane createPlane(String item) {
        if (item.equals("100")) {
            return new TPX100();
        } else if (item.equals("200")) {
            return new TPX200();
        } else if (item.equals("300")) {
            return new TPX300();
        } else return null;
    }
}
