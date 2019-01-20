package tai;

/**
 * Plane sinifindan turetilen TPX100 sinifi TAI' nin TPX modelli ucaklarindan 100 serili urunudur.
 * @author Yunus CEVIK
 */
public class TPX100 extends Plane {
    /**
     * TPX100 ucak modeli icerisinde kendisine ait bilgiler barindirir.
     */
    public TPX100(){
        model = "TPX 100";
        purpose = "Domestic flights";
        skeleton = "Aluminum alloy";
        engine = "Single jet engine";
        seating = "50 seats";
    }
}
