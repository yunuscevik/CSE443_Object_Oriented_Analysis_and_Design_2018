
package linearsolverdeluxe;

/**
 * MethodsBehavior interface yapisina bagli metotlari tetiklemek icin olusturulmus soyut sinif.
 * @author Yunus CEVIK
 */
public abstract class Solver {
    private MethodsBehavior methodsBehavior;
    /**
     * Dinamik olarak hangi methodun kullanilacagi belirlenir.
     * @param methodsBehavior Dinamik olarak hangi metodun oldugu MethodsBehavior olarak belirlenir.
     */
    public Solver(MethodsBehavior methodsBehavior) {
        this.methodsBehavior = methodsBehavior;
    }
    
    /**
     * Dinamik olarak hangi methodun belirlenecegi set edilir.
     * @param methodsBehavior Dinamik olarak hangi metodun oldugu MethodsBehavior olarak belirlenir.
     */
    public void setMethodsBehavior(MethodsBehavior methodsBehavior) {
        this.methodsBehavior = methodsBehavior;
    }
    
    /**
     * Kullanicidan alinan matris ile methodsBehavior interface' inde bulunan abstract solve metodu cagrilir.
     * Dinamik olarak hangi metodun solve metodunun cagrilacagi belirlenir.
     * @param matrix Kullanicidan alinan matris
     */
    public void methodsSolver(Double[][] matrix){
        methodsBehavior.solve(matrix);
    }
    
    

}
