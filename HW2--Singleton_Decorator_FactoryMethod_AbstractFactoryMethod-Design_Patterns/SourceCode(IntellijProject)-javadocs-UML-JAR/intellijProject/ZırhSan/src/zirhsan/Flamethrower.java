package zirhsan;

/**
 * CustomWeapons sinifindan extends edilerek  Armored Suits yaninda Flamethrower silahin kullanilacagini belirler.
 * @author Yunus CEVIK
 */
public class Flamethrower extends CustomWeapons {
    ArmoredSuits armoredSuits;

    /**
     * Hangi Armored Suits ile kullanilacagi belirlenir.
     * @param armoredSuits Herhangi bir armored suits alan parametre
     */
    public Flamethrower(ArmoredSuits armoredSuits) {
        this.armoredSuits = armoredSuits;
    }

    /**
     * Custom Weapons' tan hangi silahin kullanildigini belirtir.
     * @return Custom Weapons' tan hangi silahin kullanildigini return eder
     */
    public String getDescription() {
        return armoredSuits.getDescription() + ", Flamethrower";
    }

    /**
     * Flamethrower silahinin maliyeti
     * @return Flamethrower silahinin maliyetini return eder
     */
    @Override
    public double cost() {
        return 50 + armoredSuits.cost();
    }

    /**
     * Flamethrower silahinin agirligi
     * @return Flamethrower silahinin agirligini return eder
     */
    @Override
    public double weight() {
        return 2 + armoredSuits.weight();
    }
}
