package tai_abstfact;

/**
 * Abstract olarak belirlenen bu sinif TAI' de uretilen tum ucaklarin uretilme asamasinda sirayla nelerin olustugunu gosterir.
 * Tum ucaklarin ortak yapilarinin nasil ve hangi malzemlerden yapildigini belirterek ucak uretimi gerçeklestirilir.
 * @author Yunus CEVIK
 */
public abstract class TAIPlanesStore {
    abstract Plane createPlane(String item);

    /**
     * TAI' de sirayla hangi ucaklarin uretilecegini belirler.
     * @param type Uretilecek ucak tipinin belirtildigi parametre
     * @return Uretilen ucak tipinin return edilmesi.
     */
    public Plane orderPlane(String type) {
        Plane plane = createPlane(type);
        System.out.println("--- Making a " + plane.getModel() + " ---");
        plane.prepare();
        return plane;
    }
}
