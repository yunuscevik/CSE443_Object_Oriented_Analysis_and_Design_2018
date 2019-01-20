package tai_abstfact;

/**
 * Ucak malzemeleri Fabrikasi interface' inden implements edilen Diger Malzemeler Fabrikasi
 * @author Yunus CEVIK
 */
public class OtherIngrFact implements PlaneIngrFact {
    /**
     * Motor enjeksiyonu olarak GearedTurbofan olusturulur
     * @return GearedTurbofan olusturulur ve return edilir.
     */
    @Override
    public EngineInjection createEngineInjection() {
        return new GearedTurbofan();
    }

    /**
     * Koltuk kilifi olarak deri(Leather) tipinde olusturulur
     * @return deri(Leather) olusturulur ve return edilir.
     */
    @Override
    public SeatingCover createSeatingCover() {
        return new Leather();
    }
}
