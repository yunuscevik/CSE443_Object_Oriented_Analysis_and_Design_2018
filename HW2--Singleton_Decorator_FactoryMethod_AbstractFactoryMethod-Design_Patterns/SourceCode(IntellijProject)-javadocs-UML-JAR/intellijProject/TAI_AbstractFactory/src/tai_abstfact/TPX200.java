package tai_abstfact;

/**
 * Plane sinfinden turetilen TPX200 sinifi.
 * @author Yunus CEVIK
 */
public class TPX200 extends Plane {
    PlaneIngrFact planeIngrFact;

    /**
     * TPX200 ucak modelinin hangi ucak malzemelerini kullandigi ve nerelerdeki fabrikalardan kullanildigini belirtir.
     * @param planeIngrFact Ucak malzemelerini ve nereden tedarik edildigini bildiren parametre
     */
    public TPX200(PlaneIngrFact planeIngrFact){
        this.planeIngrFact = planeIngrFact;
    }

    /**
     * TPX200 ucak modelinin hazirlanmasi ve hangi malzemlerin kullanacagi belirlenir.
     */
    @Override
    void prepare() {
        System.out.println("Preparing " + model);
        engineInjection = planeIngrFact.createEngineInjection();
        seatingCover = planeIngrFact.createSeatingCover();
    }
}
