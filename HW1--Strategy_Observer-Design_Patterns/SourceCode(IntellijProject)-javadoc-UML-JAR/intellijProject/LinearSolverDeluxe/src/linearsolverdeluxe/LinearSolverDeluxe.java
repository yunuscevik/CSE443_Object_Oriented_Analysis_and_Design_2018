
package linearsolverdeluxe;

/**
 * Dinamik olarak hangi metodun oldugu MethodsBehavior olarak belirlenir ve mevcut olan metodlar secilir.
 * Solver sinifindan extends edildiginden super metodu cagrilir.
 * @author Yunus CEVIK
 */
public class LinearSolverDeluxe extends Solver{
    
    public LinearSolverDeluxe(MethodsBehavior methodsBehavior) {
        super(methodsBehavior);
    }   
}
