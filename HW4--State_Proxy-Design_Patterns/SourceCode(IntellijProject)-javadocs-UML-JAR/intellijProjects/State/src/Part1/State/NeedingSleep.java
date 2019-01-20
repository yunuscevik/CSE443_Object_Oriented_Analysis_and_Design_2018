package Part1.State;

import Part1.Student;
/**
 * Abstract olan AbstractState sinifindan extends edilmis olan siniftir.
 * @author Yunus CEVIK
 */
public class NeedingSleep extends AbstractState {
    /**
     * Constructor
     * @param student Student olarak gelen parametre ile Abstract sinifin super metoduna vererek Abstract sinif ile calismasi saglanir.
     */
    public NeedingSleep(Student student) {
        super(student);
    }
    /**
     * coffeeAndWork islemininde  durumunu chronicIllnessState olarak degistirir.
     */
    @Override
    public void coffeeAndWork() {
        changeState("Coffee and work", getStudent().getChronicIllnessState());
    }
    /**
     * coffeeAndWork islemininde  durumunu readyState olarak degistirir.
     */
    @Override
    public void sleep() {
        changeState("Sleep", getStudent().getReadyState());
    }
}
