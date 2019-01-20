package tai_abstfact;

/**
 * Ucak malzemelerinin bulundugu fabrika interface sinifi
 * @author Yunus CEVIK
 */
public interface PlaneIngrFact {
    public EngineInjection createEngineInjection();
    public SeatingCover createSeatingCover();
}
