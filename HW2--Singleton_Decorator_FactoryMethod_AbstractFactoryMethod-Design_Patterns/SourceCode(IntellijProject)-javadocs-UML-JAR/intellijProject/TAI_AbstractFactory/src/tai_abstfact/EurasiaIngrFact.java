package tai_abstfact;

/**
 * Ucak malzemeleri Fabrikasi interface' inden implements edilen Avrasya Malzemeleri Fabrikasi
 * @author Yunus CEVIK
 */
public class EurasiaIngrFact implements PlaneIngrFact {
    /**
     * Motor enjeksiyonu olarak Turbofan olusturulur
     * @return Turbofan olusturulur ve return edilir.
     */
    @Override
    public EngineInjection createEngineInjection() {
        return new Turbofan();
    }

    /**
     * Koltuk kilifi olarak keten(Linen) tipinde olusturulur
     * @return keten(Linen) olusturulur ve return edilir.
     */
    @Override
    public SeatingCover createSeatingCover() {
        return new Linen();
    }
}
