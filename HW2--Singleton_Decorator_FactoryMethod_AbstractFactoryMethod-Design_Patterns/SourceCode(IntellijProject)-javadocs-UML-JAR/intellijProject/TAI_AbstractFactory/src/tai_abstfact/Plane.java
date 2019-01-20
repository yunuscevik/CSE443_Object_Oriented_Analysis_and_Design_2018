package tai_abstfact;

/**
 * TAI' de uretilen ucak sinifi. Bu sinif icerisinde motor enjeksiyonu ve koltuk kilifi bulunmaktadır.
 * @author Yunus CEVIK
 */
public abstract class Plane {
    String model;
    EngineInjection engineInjection;
    SeatingCover seatingCover;

    abstract void prepare();

    /**
     * Uretilen ucak modelinin setter metodu
     * @param model String tipinde model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Uretilen ucak Modeli
     * @return Uretilen ucak modelinin return edilmesi
     */
    public String getModel(){
        return model;
    }

    /**
     * Uretilen Ucagin model motor enjeksiyonu ve koltuk kilifi hakkinda tum bilgilerin verildigi toString metodu.
     * @return Uretilen ucagin tum bilgileri return edilir.
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("---- " + model + " ----\n");
        if (engineInjection != null) {
            result.append(engineInjection.toString());
            result.append("\n");
        }
        if (seatingCover != null) {
            result.append(seatingCover.toString());
            result.append("\n");
        }
        return result.toString();
    }
}
