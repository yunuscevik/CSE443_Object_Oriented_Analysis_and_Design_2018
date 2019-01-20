package tai;

/**
 * TAI' de uretilen ucak sinifi. Bu sinif icerisinde ucagin iskeleti, motoru ve koltuk sayisi bulunmaktadır.
 * @author Yunus CEVIK
 */
public class Plane {
    String model;
    String purpose;
    String skeleton;
    String engine;
    String seating;

    /**
     * Ucak hazirlanirken hangi modelin hangi asamalarinin hazirlandigina ait bilgilerin verildigi metot.
     */
    void prepare() {
        System.out.println("Prepare " + model);
        System.out.println("Creating the skeleton...");
        System.out.println("Adding engine...");
        System.out.println("Adding seating: ");
    }

    /**
     * Uretilen ucagin amaci
     */
    void purpose(){
        System.out.println("Purpose: " + purpose);
    }

    /**
     * Uretilen ucagin iskelet yapisinin bilgileri
     */
    void constructSkeleton(){
        System.out.println("Skeleton: " + skeleton);
    }

    /**
     * Uretilen ucagin motor bilgileri
     */
    void placeEngines(){
        System.out.println("Engine: " + engine);
    }

    /**
     * Uretilen ucagin koltuk bilgileri
     */
    void placeSeats(){
        System.out.println("Seating: " + seating);
    }

    /**
     * Uretilen ucak Modeli
     * @return Uretilen ucak modelinin return edilmesi
     */
    public String getModel(){
        return model;
    }

    /**
     * Uretilen Ucagin model, amaci, iskeleti, motoru ve koltuklari hakkinda tum bilgilerin verildigi toString metodu.
     * @return Uretilen ucagin tum bilgileri return edilir.
     */
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---- " + model + " ----\n");
        display.append("Purpose: " + purpose + "\n");
        display.append("Skeleton: " + skeleton + "\n");
        display.append("Engine: " + engine + "\n");
        display.append("Seating: " + seating + "\n");
        return display.toString();
    }
}
