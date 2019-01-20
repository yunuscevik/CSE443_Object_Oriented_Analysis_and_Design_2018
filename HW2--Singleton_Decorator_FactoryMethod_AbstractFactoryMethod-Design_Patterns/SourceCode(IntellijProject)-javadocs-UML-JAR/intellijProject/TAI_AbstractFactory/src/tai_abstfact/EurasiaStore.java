package tai_abstfact;

/**
 * TAIPlaneStore'dan extends edilmis EurasiaStore
 * @author Yunus CEVIK
 */
public class EurasiaStore extends TAIPlanesStore{

    /**
     * Avrasya Magazada uretilecek ucaklar
     * @param item Avrasya Magazada uretilecek ucak tipi parametresi
     * @return Uretilen ucak return edilir.
     */
    @Override
    Plane createPlane(String item) {
        Plane plane = null;
        PlaneIngrFact planeIngrFact = new EurasiaIngrFact();
        if (item.equals("100")) {

            plane = new TPX100(planeIngrFact);
            plane.setModel("TPX100");

        } else if (item.equals("200")) {
            plane = new TPX200(planeIngrFact);
            plane.setModel("TPX200");

        } else if (item.equals("300")) {
            plane = new TPX300(planeIngrFact);
            plane.setModel("TPX300");
        }
        return plane;
    }
}
