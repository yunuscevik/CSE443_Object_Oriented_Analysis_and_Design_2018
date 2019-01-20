package Part1.State;

import Part1.Student;
/**
 * Abstract olan AbstractState sinifindan extends edilmis olan siniftir.
 * @author Yunus CEVIK
 */
public class UnableToBecomeARodForAnAxe extends AbstractState {
    /**
     * Constructor
     * @param student Student olarak gelen parametre ile Abstract sinifin super metoduna vererek Abstract sinif ile calismasi saglanir.
     */
    public UnableToBecomeARodForAnAxe(Student student) {
        super(student);
    }
}