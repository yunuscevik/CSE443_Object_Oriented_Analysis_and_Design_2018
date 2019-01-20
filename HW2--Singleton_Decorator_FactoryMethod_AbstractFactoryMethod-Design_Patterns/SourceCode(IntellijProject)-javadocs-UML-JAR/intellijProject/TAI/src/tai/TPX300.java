package tai;

/**
 * Plane sinifindan turetilen TPX300 sinifi TAI' nin TPX modelli ucaklarindan 300 serili urunudur.
 * @author Yunus CEVIK
 */
public class TPX300 extends Plane {
    /**
     * TPX300 ucak modeli icerisinde kendisine ait bilgiler barindirir.
     */
    public TPX300(){
        model = "TPX 300";
        purpose = "Transatlantic flights";
        skeleton = "Titanium alloy";
        engine = "Quadro jet engines";
        seating = "250 seats";
    }
}
