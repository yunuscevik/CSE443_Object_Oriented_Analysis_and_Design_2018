package Part1.State;

import Part1.Student;
/**
 * Abstract olan AbstractState sinifindan extends edilmis olan siniftir.
 * @author Yunus CEVIK
 */
public class Ready extends AbstractState {
    /**
     * Constructor
     * @param student Student olarak gelen parametre ile Abstract sinifin super metoduna vererek Abstract sinif ile calismasi saglanir.
     */
    public Ready(Student student) {
        super(student);
    }
    /**
     * buyingGTX1080 islemininde  durumunu unableToBecomeARodForAnAxeState olarak degistirir.
     */
    @Override
    public void buyingGTX1080() {
        changeState("Buying GTX1080", getStudent().getUnableToBecomeARodForAnAxeState());
    }
    /**
     * cheating islemininde  durumunu unableToBecomeARodForAnAxeState olarak degistirir.
     */
    @Override
    public void cheating() {
        changeState("Cheating", getStudent().getUnableToBecomeARodForAnAxeState());
    }
    /**
     * exercise islemininde  durumunu fitState olarak degistirir.
     */
    @Override
    public void exercise() {
        changeState("Exercise", getStudent().getFitState());
    }
    /**
     * perseveranceAndHardWork islemininde  durumunu graduateState olarak degistirir.
     */
    @Override
    public void perseveranceAndHardWork() {
        changeState("Perseverance and hard work", getStudent().getGraduateState());
    }
    /**
     * outTillLate islemininde  durumunu needingSleepState olarak degistirir.
     */
    @Override
    public void outTillLate() {
        changeState("Out till late", getStudent().getNeedingSleepState());
    }
}

