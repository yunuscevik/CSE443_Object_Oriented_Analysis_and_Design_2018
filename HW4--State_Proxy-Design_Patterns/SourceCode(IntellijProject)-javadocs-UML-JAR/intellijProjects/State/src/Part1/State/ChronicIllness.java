package Part1.State;

import Part1.Student;

/**
 * Abstract olan AbstractState sinifindan extends edilmis olan siniftir.
 * @author Yunus CEVIK
 */
public class ChronicIllness extends AbstractState {
    /**
     * Constructor
     * @param student Student olarak gelen parametre ile Abstract sinifin super metoduna vererek Abstract sinif ile calismasi saglanir.
     */
    public ChronicIllness(Student student) {
        super(student);
    }
}
