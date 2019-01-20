package zirhsan;

/**
 * ArmoredSuit sinifindan extends edilen tor sinifi, bir tur zirhli elbisedir
 * @author Yunus CEVIK
 */
public class tor extends ArmoredSuits {

    /**
     * Constructor da description verilen isim ile ArmoredSuits icerisinden hangisinin kullanildigi belirtilir.
     */
    public tor() {
        description = "Tor Armored Suits";
    }

    /**
     * Tor Armored Suits' in maliyeti
     * @return Ora Armored Suits' in maliyetini return eder.
     */
    public double cost() {
        return 5000;
    }

    /**
     * Tor Armored Suits' in agirligi
     * @return Tor Armored Suits' in agirligini return eder.
     */
    @Override
    public double weight() {
        return 50;
    }
}
