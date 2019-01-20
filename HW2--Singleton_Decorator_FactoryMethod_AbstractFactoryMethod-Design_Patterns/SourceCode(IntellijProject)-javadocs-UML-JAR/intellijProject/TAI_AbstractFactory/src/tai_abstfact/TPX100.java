package tai_abstfact;

/**
 * Plane sinfinden turetilen TPX100 sinifi.
 * @author Yunus CEVIK
 */
public class TPX100 extends Plane {
    PlaneIngrFact planeIngrFact;

    /**
     * TPX100 ucak modelinin hangi ucak malzemelerini kullandigi ve nerelerdeki fabrikalardan kullanildigini belirtir.
     * @param planeIngrFact Ucak malzemelerini ve nereden tedarik edildigini bildiren parametre
     */
    public TPX100(PlaneIngrFact planeIngrFact){
        this.planeIngrFact = planeIngrFact;
    }

    /**
     * TPX100 ucak modelinin hazirlanmasi ve hangi malzemlerin kullanacagi belirlenir.
     */
    @Override
    void prepare() {
        System.out.println("Preparing " + model);
        engineInjection = planeIngrFact.createEngineInjection();
        seatingCover = planeIngrFact.createSeatingCover();
    }
}
