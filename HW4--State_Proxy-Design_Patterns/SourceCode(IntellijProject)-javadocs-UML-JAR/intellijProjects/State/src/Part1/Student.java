package Part1;
import Part1.State.*;

/**
 * Bir ogrencinin yapmasi gereken durumlar
 * @author Yunus CEVIK
 */
public class Student {
    private State chronicIllness;
    private State fit;
    private State graduate;
    private State needingSleep;
    private State ready;
    private State unableToBecomeARodForAnAxe;
    private State state;

    /**
     * Constructor
     */
    public Student() {
        chronicIllness = new ChronicIllness(this);
        fit = new Fit(this);
        graduate = new Graduate(this);
        needingSleep = new NeedingSleep(this);
        ready = new Ready(this);
        unableToBecomeARodForAnAxe = new UnableToBecomeARodForAnAxe(this);

        state = ready;
    }

    /**
     * Getter
     * @return State return eder
     */
    public String getStateName() {
        return state.toString();
    }
    /**
     * Getter
     * @return chronicIllness return eder
     */
    public State getChronicIllnessState() {
        return chronicIllness;
    }
    /**
     * Getter
     * @return fit return eder
     */
    public State getFitState() {
        return fit;
    }
    /**
     * Getter
     * @return graduate return eder
     */
    public State getGraduateState() {
        return graduate;
    }
    /**
     * Getter
     * @return needingSleep return eder
     */
    public State getNeedingSleepState() {
        return needingSleep;
    }
    /**
     * Getter
     * @return ready return eder
     */
    public State getReadyState() {
        return ready;
    }
    /**
     * Getter
     * @return unableToBecomeARodForAnAxe return eder
     */
    public State getUnableToBecomeARodForAnAxeState() {
        return unableToBecomeARodForAnAxe;
    }
    /**
     * Setter
     * @param state Parametre olarak verilen State' i sinifin state degiskenine atar.
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * coffeeAndWork durumunun calistirilmasi
     */
    public void coffeeAndWork() {
        state.coffeeAndWork();
    }
    /**
     * sleep durumunun calistirilmasi
     */
    public void sleep() {
        state.sleep();
    }
    /**
     * outTillLate durumunun calistirilmasi
     */
    public void outTillLate() {
        state.outTillLate();
    }
    /**
     * perseveranceAndHardWork durumunun calistirilmasi
     */
    public void perseveranceAndHardWork() {
        state.perseveranceAndHardWork();
    }
    /**
     * exercise durumunun calistirilmasi
     */
    public void exercise() {
        state.exercise();
    }
    /**
     * buyingGTX1080 durumunun calistirilmasi
     */
    public void buyingGTX1080() {
        state.buyingGTX1080();
    }
    /**
     * cheating durumunun calistirilmasi
     */
    public void cheating() {
        state.cheating();
    }
}
