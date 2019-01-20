package payment_Adapter;

/**
 * TurboPayment arayuzunun somut sinifidir.
 * @author Yunus CEVIK
 */
public class TargetTurboPayment implements TurboPayment {

    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        return (int) turboAmount;
    }
}
