package Part1.State;

import Part1.Student;

/**
 * Abstract olan AbstractState sinifindan extends edilmis olan siniftir.
 * @author Yunus CEVIK
 */
public class Fit extends AbstractState {
    /**
     * Constructor
     * @param student Student olarak gelen parametre ile Abstract sinifin super metoduna vererek Abstract sinif ile calismasi saglanir.
     */
    public Fit(Student student) {
        super(student);
    }

    /**
     * perseveranceAndHardWork islemininde  durumunu graduateState olarak degistirir.
     */
    @Override
    public void perseveranceAndHardWork() {
        changeState("Perseverance and hard work", getStudent().getGraduateState());
    }
}
