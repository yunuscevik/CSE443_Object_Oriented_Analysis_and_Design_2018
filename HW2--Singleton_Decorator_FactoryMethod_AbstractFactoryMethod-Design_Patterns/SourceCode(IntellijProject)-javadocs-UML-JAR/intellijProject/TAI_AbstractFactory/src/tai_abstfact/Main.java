package tai_abstfact;

/**
 * TAI ' de uretilen ucaklarin belirlendigi Main sinifi.
 * @author Yunus CEVIK
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------------");
        TAIPlanesStore tpx1 = new DomesticStore();
        TAIPlanesStore tpx2 = new EurasiaStore();
        TAIPlanesStore tpx3 = new OtherStore();
        Plane plane;
        plane = tpx1.orderPlane("100");
        System.out.println("\n---- Prepared Plane ----\n" + plane.toString());
        System.out.println("------------------------------------------");
        plane = tpx2.orderPlane("200");
        System.out.println("\n---- Prepared Plane ----\n" + plane.toString());
        System.out.println("------------------------------------------");
        plane = tpx3.orderPlane("300");
        System.out.println("\n---- Prepared Plane ----\n" + plane.toString());
        System.out.println("------------------------------------------");
    }
}


