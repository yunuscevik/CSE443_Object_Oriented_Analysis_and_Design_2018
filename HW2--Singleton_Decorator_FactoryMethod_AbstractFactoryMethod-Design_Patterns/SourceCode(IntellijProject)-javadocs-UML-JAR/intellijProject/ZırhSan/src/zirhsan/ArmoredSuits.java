package zirhsan;

/**
 * Abstract olarak belirlenmis ArmoredSuits sinifi, diger siniflara extends edilerek icerisinde bulunan abstract metodlarin
 * extends edilen siniflarin ortak ozelliklerinin barindirildigi metodlardir.
 * @author Yunus CEVIK
 */
public abstract class ArmoredSuits {
    String description = "Unknown ArmoredSuits";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
    public abstract double weight();
}
