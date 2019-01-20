package Part1.State;

import Part1.Student;

/**
 * State interface yapisindan implements edilmis abstract siniftir.
 * @author Yunus CEVIK
 */
public abstract class AbstractState implements State {
    private Student student;

    /**
     * Constructor
     * @param student Student parametresi alan constructor.
     */
    public AbstractState(Student student) {
        this.student = student;
    }

    /**
     * Stateler arasi gecisi saglar
     * @param action Hangi state icerisinde hangi islemi yapacagini gosterir.
     * @param newState Hangi stateden hangi state durumuna gectigini belirtir.
     */
    protected void changeState(String action, State newState) {
        System.out.println("Current state: " + getStudent().getStateName());
        System.out.println("Action process: " + action);
        getStudent().setState(newState);
        System.out.println("New Target state: " + newState.toString() + "\n");
    }

    /**
     * Getter
     * @return student return eder.
     */
    protected Student getStudent() {
        return student;
    }

    /**
     * coffeeAndWork error durumu
     */
    @Override
    public void coffeeAndWork() {
        printErrorMessage("coffee & work");
    }

    /**
     * sleep error durumu
     */
    @Override
    public void sleep() {
        printErrorMessage("sleep");
    }
    /**
     * outTillLate error durumu
     */
    @Override
    public void outTillLate() {
        printErrorMessage("out till late");
    }
    /**
     * perseveranceAndHardWork error durumu
     */
    @Override
    public void perseveranceAndHardWork() {
        printErrorMessage("perseverance and hard work");
    }
    /**
     * exercise error durumu
     */
    @Override
    public void exercise() {
        printErrorMessage("exercise");
    }
    /**
     * buyingGTX1080 error durumu
     */
    @Override
    public void buyingGTX1080() {
        printErrorMessage("buying GTX1080");
    }
    /**
     * cheating error durumu
     */
    @Override
    public void cheating() {
        printErrorMessage("cheating");
    }

    /**
     * Hatali olan durumlari ekrana cikti olarak vermeye yarayan metottur.
     * @param action Action parametresi ile hangi islem sirasinda hata oldugu gosterilir.
     */
    private void printErrorMessage(String action) {
        System.out.println(toString() + " state doesn't support " + action + " action");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
