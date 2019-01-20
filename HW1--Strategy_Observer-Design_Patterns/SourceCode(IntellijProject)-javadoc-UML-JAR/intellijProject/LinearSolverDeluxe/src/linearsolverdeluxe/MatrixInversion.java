
package linearsolverdeluxe;

/**
 * Matrislerin cozulmeleri icin kullanilacak Matrix Inversion metodu.
 * MethodsBehavior interface' inden implements edilir. 
 * @author Yunus CEVIK
 */
public class MatrixInversion implements MethodsBehavior{
    private Double xMatrix[];
    @Override
    public void solve(Double[][] matrix) {
        int size = matrix.length;
        Double[] bMatrix = new Double[size];
        for(int i = 0; i < size; i++)
            bMatrix[i] = matrix[i][size];
        xMatrix = new Double[size];
        try { 
            matrixInversion(matrix, bMatrix, xMatrix, size);
            GUI.resultPrint("Result", this.toString());
        }  
        catch(ArithmeticException e){
            GUI.resultPrint("Warning", e.getMessage());
        }
    }
    
    /**
     * Matrisler icin kullanilacak metotlarin Override edilmis olan toString metotu.
     * @return Matris sonucunu bir string icerisinde belirli bir formatta return eder.
     */
    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < xMatrix.length; i++){
               result +=  ("x"+(i+1)+ " => " + xMatrix[i] + "\n");
        }
        result += "\n";
        return result;
    }
    
   /**
     * Matrix Inversion metodu.
     * @param matrix A.x = B formulundeki cozulecek A matrisi tersi (input)
     * @param bMatrix A.x = B formulundeki A ile X matrislerinin carpimlarinin sonucu olan B matrisi (input)
     * @param xMatrix A.x = B formulundeki bilinmeyen degerlerin yer aldigi X matrisi (output)
     * @param n Kare matrisin boyutu
     */
    public void matrixInversion (Double[][] matrix, Double[] bMatrix, Double[] xMatrix,int n){
        Double [][]resultMatrix = inverseMatrix(matrix, n);
        double sum = 0.0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
              sum += resultMatrix[i][j] * bMatrix[j];
            xMatrix[i] = sum;
            sum = 0.0;
        }
    }
    
    /**
     * Bir matrisin tersini determinantsız alan metottur.
     * Gaussian Elimination metodunu kullanayarak [A\I] = [I\A^-1]
     * @param matrix Tersi alinacak matris
     * @param n Tersi alinacak matrisin boyutu
     * @return Tersi alindiktan sonra return edilen Ters Matris.
     */
    private Double[][] inverseMatrix(Double matrix[][], int n){
        Double retMatrix[][] = new Double[n][n];
        Double bMatrix[][] = new Double[n][n];
        Integer index[] = new Integer[n];
        for (int i=0; i < n; ++i){
            for(int j = 0; j < n; j++){
                if(i == j)
                    bMatrix[i][j] = 1.0;
                else
                    bMatrix[i][j] = 0.0;
            }
        }
 
        gaussian(matrix, index);
 
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                for (int k = 0; k < n; k++)
                    bMatrix[index[j]][k] -= matrix[index[j]][i] * bMatrix[index[i]][k];  
            }
        }

        // Backward substitutions
        for (int i = 0; i < n; i++){   
            if(matrix[index[n-1]][n-1] == 0.0 || "NaN".equals(""+ matrix[index[n-1]][n-1]) )
                throw new ArithmeticException("Inverse Matrix does not exist!!!");
            else
                retMatrix[n-1][i] = bMatrix[index[n-1]][i] / matrix[index[n-1]][n-1];
            
            for (int j = n-2; j >= 0; j--){
                retMatrix[j][i] = bMatrix[index[j]][i];
                for (int k = j+1; k < n; ++k){
                    retMatrix[j][i] -= matrix[index[j]][k] * retMatrix[k][i];
                }
                retMatrix[j][i] /= matrix[index[j]][j];
            }
        }
        return retMatrix;
    }
 
    /**
     * Gaussian Elimination  
     * @param matrix Elimination yontemi uygulanacak matris
     * @param index  Pivot degerlerinin indekslerini tutan dizi.
     */
    private void gaussian(Double matrix[][], Integer index[]) {
        int size = index.length;
        Double c[] = new Double[size];
 
        for (int i = 0; i < size; ++i) 
            index[i] = i;
 
        for (int i=0; i < size; i++){
            double c1 = 0;
            for (int j=0; j < size; j++){
                double c0 = Math.abs(matrix[i][j]);
                if (c0 > c1) 
                    c1 = c0;
            }
            c[i] = c1;
        }
 
        int k = 0;
        for (int j = 0; j < size-1; j++){
            double pi1 = 0;
            for (int i = j; i < size; i++){
                double pi0 = Math.abs(matrix[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
            
            // Pivot sirasina gore swap islemi
            int itemp = index[j];
            index[j] = index[k];
            index[k] = itemp;
            
            for (int i = j+1; i < size; i++){
                double pj = matrix[index[i]][j] / matrix[index[j]][j]; 
                matrix[index[i]][j] = pj;
                for (int l = j+1; l < size; l++)
                   matrix[index[i]][l] -= pj * matrix[index[j]][l];
            }
        }
    }
}