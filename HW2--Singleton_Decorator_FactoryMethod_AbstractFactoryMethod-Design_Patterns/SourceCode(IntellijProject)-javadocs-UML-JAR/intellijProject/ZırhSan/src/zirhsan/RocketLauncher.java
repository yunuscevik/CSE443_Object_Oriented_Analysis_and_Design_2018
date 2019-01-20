package zirhsan;

/**
 * CustomWeapons sinifindan extends edilerek  Armored Suits yaninda RocketLauncher silahin kullanilacagini belirler.
 * @author Yunus CEVIK
 */
public class RocketLauncher extends CustomWeapons {
    ArmoredSuits armoredSuits;

    /**
     * Hangi Armored Suits ile kullanilacagi belirlenir.
     * @param armoredSuits Herhangi bir armored suits alan parametre
     */
    public RocketLauncher(ArmoredSuits armoredSuits) {
        this.armoredSuits = armoredSuits;
    }

    /**
     * Custom Weapons' tan hangi silahin kullanildigini belirtir.
     * @return Custom Weapons' tan hangi silahin kullanildigini return eder
     */
    public String getDescription() {
        return armoredSuits.getDescription() + ", RocketLauncher";
    }

    /**
     * RocketLauncher silahinin maliyeti
     * @return RocketLauncher silahinin maliyetini return eder
     */
    @Override
    public double cost() {
        return 150 + armoredSuits.cost();
    }

    /**
     * RocketLauncher silahinin agirligi
     * @return RocketLauncher silahinin agirligini return eder
     */
    @Override
    public double weight() {
        return 7.5 + armoredSuits.weight();
    }
}