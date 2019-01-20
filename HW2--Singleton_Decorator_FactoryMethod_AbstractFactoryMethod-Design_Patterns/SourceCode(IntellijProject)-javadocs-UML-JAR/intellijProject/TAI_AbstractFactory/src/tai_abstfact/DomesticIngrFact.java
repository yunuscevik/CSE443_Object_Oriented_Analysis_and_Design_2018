package tai_abstfact;

/**
 * Ucak malzemeleri Fabrikasi interface' inden implements edilen Yerli Malzemeleri Fabrikasi
 * @author Yunus CEVIK
 */
public class DomesticIngrFact implements PlaneIngrFact {
    /**
     * Motor enjeksiyonu olarak Turbojet olusturulur
     * @return Turbojet olusturulur ve return edilir.
     */
    @Override
    public EngineInjection createEngineInjection() {
        return new Turbojet();
    }

    /**
     * Koltuk kilifi olarak kadife(Velvet) tipinde olusturulur
     * @return kadife(Velvet) olusturulur ve return edilir.
     */
    @Override
    public SeatingCover createSeatingCover() {
        return new Velvet();
    }
}
