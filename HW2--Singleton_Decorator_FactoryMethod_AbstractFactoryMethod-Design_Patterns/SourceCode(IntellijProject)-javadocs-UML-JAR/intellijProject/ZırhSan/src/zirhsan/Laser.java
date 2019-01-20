package zirhsan;


/**
 * CustomWeapons sinifindan extends edilerek  Armored Suits yaninda Laser silahin kullanilacagini belirler.
 * @author Yunus CEVIK
 */
public class Laser extends CustomWeapons {
    ArmoredSuits armoredSuits;

    /**
     * Hangi Armored Suits ile kullanilacagi belirlenir.
     * @param armoredSuits Herhangi bir armored suits alan parametre
     */
    public Laser(ArmoredSuits armoredSuits) {
        this.armoredSuits = armoredSuits;
    }

    /**
     * Custom Weapons' tan hangi silahin kullanildigini belirtir.
     * @return Custom Weapons' tan hangi silahin kullanildigini return eder
     */
    public String getDescription() {
        return armoredSuits.getDescription() + ", Laser";
    }

    /**
     * Laser silahinin maliyeti
     * @return Laser silahinin maliyetini return eder
     */
    public double cost() {
        return 200 + armoredSuits.cost();
    }

    /**
     * Laser silahinin agirligi
     * @return Laser silahinin agirligini return eder
     */
    @Override
    public double weight() {
        return 5.5 + armoredSuits.weight();
    }
}