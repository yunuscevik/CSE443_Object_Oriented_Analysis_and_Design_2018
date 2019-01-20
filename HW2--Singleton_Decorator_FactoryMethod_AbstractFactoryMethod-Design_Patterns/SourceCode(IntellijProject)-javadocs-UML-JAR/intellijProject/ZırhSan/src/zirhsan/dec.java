package zirhsan;

/**
 * ArmoredSuit sinifindan extends edilen dec sinifi, bir tur zirhli elbisedir
 * @author Yunus CEVIK
 */
public class dec extends ArmoredSuits {
    /**
     * Constructor da description verilen isim ile ArmoredSuits icerisinden hangisinin kullanildigi belirtilir.
     */
    public dec() {
        description = "Dec Armored Suits";
    }

    /**
     * Dec Armored Suits' in maliyeti
     * @return Dec Armored Suits' in maliyetini return eder.
     */
    public double cost() {
        return 500;
    }

    /**
     * Dec Armored Suits' in agirligi
     * @return Dec Armored Suits' in agirligini return eder.
     */
    @Override
    public double weight() {
        return 25;
    }
}