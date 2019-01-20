package tai_abstfact;

/**
 * Plane sinfinden turetilen TPX300 sinifi.
 * @author Yunus CEVIK
 */
public class TPX300 extends Plane {
    PlaneIngrFact planeIngrFact;

    /**
     * TPX300 ucak modelinin hangi ucak malzemelerini kullandigi ve nerelerdeki fabrikalardan kullanildigini belirtir.
     * @param planeIngrFact Ucak malzemelerini ve nereden tedarik edildigini bildiren parametre
     */
    public TPX300(PlaneIngrFact planeIngrFact){
        this.planeIngrFact = planeIngrFact;
    }

    /**
     * TPX300 ucak modelinin hazirlanmasi ve hangi malzemlerin kullanacagi belirlenir.
     */
    @Override
    void prepare() {
        System.out.println("Preparing " + model);
        engineInjection = planeIngrFact.createEngineInjection();
        seatingCover = planeIngrFact.createSeatingCover();
    }
}
