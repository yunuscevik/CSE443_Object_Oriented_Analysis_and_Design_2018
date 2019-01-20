package tai;

/**
 * TAI ' de uretilen ucaklarin belirlendigi Main sinifi.
 * @author Yunus CEVIK
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------------");
        TAIPlanesStore tpx = new TPX();
        Plane plane;
        plane = tpx.orderPlane("100");
        System.out.println("Prepared Plane: " + plane.getModel() + "\n");
        System.out.println("------------------------------------------");
        plane = tpx.orderPlane("200");
        System.out.println("Prepared Plane: " + plane.getModel() + "\n");
        System.out.println("------------------------------------------");
        plane = tpx.orderPlane("300");
        System.out.println("Prepared Plane: " + plane.getModel() + "\n");
        System.out.println("------------------------------------------");
    }
}
