package zirhsan;

/**
 * CustomWeapons sinifindan extends edilerek  Armored Suits yaninda AutoRifle silahin kullanilacagini belirler.
 * @author Yunus CEVIK
 */
public class AutoRifle extends CustomWeapons {
    ArmoredSuits armoredSuits;

    /**
     * Hangi Armored Suits ile kullanilacagi belirlenir.
     * @param armoredSuits Herhangi bir armored suits alan parametre
     */
    public AutoRifle(ArmoredSuits armoredSuits) {
        this.armoredSuits = armoredSuits;
    }

    /**
     * Custom Weapons' tan hangi silahin kullanildigini belirtir.
     * @return Custom Weapons' tan hangi silahin kullanildigini return eder
     */
    public String getDescription() {
        return armoredSuits.getDescription() + ", AutoRifle";
    }

    /**
     * AutoRifle silahinin maliyeti
     * @return AutoRifle silahinin maliyetini return eder
     */
    @Override
    public double cost() {
        return 30 + armoredSuits.cost();
    }

    /**
     * AutoRifle silahinin agirligi
     * @return AutoRifle silahinin agirligini return eder
     */
    @Override
    public double weight() {
        return 1.5 + armoredSuits.weight();
    }
}