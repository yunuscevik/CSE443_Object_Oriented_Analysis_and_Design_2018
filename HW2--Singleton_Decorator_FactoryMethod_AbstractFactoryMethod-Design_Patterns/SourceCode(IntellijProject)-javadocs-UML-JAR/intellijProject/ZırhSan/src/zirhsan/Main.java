package zirhsan;

/**
 * ZirhSan A.S.'den alinan zirhli elbiseleri ve yanlarinda bulunan ekipmanlari belirten ve hesaplayan Main sinifi.
 * @author Yunus CEVIK
 */
public class Main {

    public static void main(String args[]) {
        ArmoredSuits armoredSuits = new tor();
        System.out.println("\n"+ armoredSuits.getDescription()
                + " ==> Total Cost: "  + armoredSuits.cost() + "K TL" + ", Total Weight: " + armoredSuits.weight() +"kg");

        ArmoredSuits armoredSuits2 = new ora();
        armoredSuits2 = new AutoRifle(armoredSuits2);
        armoredSuits2 = new AutoRifle(armoredSuits2);
        armoredSuits2 = new Laser(armoredSuits2);
        System.out.println("\n"+ armoredSuits2.getDescription()
                + " ==> Total Cost: "  + armoredSuits2.cost() + "K TL" + ", Total Weight: " + armoredSuits.weight() +"kg");

        ArmoredSuits armoredSuits3 = new dec();
        armoredSuits3 = new RocketLauncher(armoredSuits3);
        armoredSuits3 = new AutoRifle(armoredSuits3);
        armoredSuits3 = new Laser(armoredSuits3);
        System.out.println("\n"+ armoredSuits3.getDescription()
                + " ==> Total Cost: "  + armoredSuits3.cost() + "K TL" + ", Total Weight: " + armoredSuits.weight() +"kg");
    }
}