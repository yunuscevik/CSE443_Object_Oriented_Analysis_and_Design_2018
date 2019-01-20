package tai;

/**
 * Plane sinifindan turetilen TPX200 sinifi TAI' nin TPX modelli ucaklarindan 200 serili urunudur.
 * @author Yunus CEVIK
 */
public class TPX200 extends Plane {
    /**
     * TPX200 ucak modeli icerisinde kendisine ait bilgiler barindirir.
     */
    public TPX200(){
        model = "TPX 200";
        purpose = "Domestic and short international flights";
        skeleton = "Nickel alloy";
        engine = "Twin jet engines";
        seating = "100 seats";
    }
}
