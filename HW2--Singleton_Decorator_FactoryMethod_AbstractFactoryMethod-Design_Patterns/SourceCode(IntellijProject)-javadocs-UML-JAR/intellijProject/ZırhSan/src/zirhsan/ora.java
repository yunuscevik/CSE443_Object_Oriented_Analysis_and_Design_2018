package zirhsan;

/**
 * ArmoredSuit sinifindan extends edilen ora sinifi, bir tur zirhli elbisedir
 * @author Yunus CEVIK
 */
public class ora extends ArmoredSuits {
    /**
     * Constructor da description verilen isim ile ArmoredSuits icerisinden hangisinin kullanildigi belirtilir.
     */
    public ora() {
        description = "Ora Armored Suits";
    }

    /**
     * Ora Armored Suits' in maliyeti
     * @return Ora Armored Suits' in maliyetini return eder.
     */
    public double cost() {
        return 1500;
    }

    /**
     * Ora Armored Suits' in agirligi
     * @return Ora Armored Suits' in agirligini return eder.
     */
    @Override
    public double weight() {
        return 30;
    }
}
