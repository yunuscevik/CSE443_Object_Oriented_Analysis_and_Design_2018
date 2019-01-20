
package linearsolverdeluxe;

import java.util.Objects;

/**
 * Matrislerin cozulmeleri icin kullanilacak Gaussian Elimination metodu.
 * MethodsBehavior interface' inden implements edilir. 
 * @author Yunus CEVIK
 */
public class GaussianElimination implements MethodsBehavior{
    private static final double ZERO = 1.0E-20; // Epsilon degeri
    private Double[] xMatrix;
    @Override
    public void solve(Double[][] matrix) {
        int size = matrix.length;
        Double[] bMatrix = new Double[size];
        for(int i = 0; i < size; i++)
            bMatrix[i] = matrix[i][size];
        xMatrix = new Double[size];
        try {
            gaussianElimination(matrix, bMatrix, xMatrix, size+1);
            GUI.resultPrint("Result",this.toString());
        } catch (Exception ex) {
            GUI.resultPrint("Warning", ex.getMessage());
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
     * Gaussian Elimination with Scaled Partial Pivoting metodu.
     * (Not: Bu kod 2016 yilinda Sayisal Analiz dersinde kendi yaptigim odevdir.)
     * @param matrix A.x = B formulundeki cozulecek A matrisi (input)
     * @param bMatrix A.x = B formulundeki A ile X matrislerinin carpimlarinin sonucu olan B matrisi (input)
     * @param xMatrix A.x = B formulundeki bilinmeyen degerlerin yer aldigi X matrisi (output)
     * @param n Kare matrisin boyutu
     * @throws Exception Eger cozum yok ise Exeption firlatilir. Bu kisim ekranda acilir bir pencerede gosterilir.
     */
    public void gaussianElimination(Double[][] matrix, Double[] bMatrix, Double[] xMatrix,int n) throws Exception{
        int i,j,k,flag=1,iMax,temp=0;
        Double[] s = new Double[n-1];
        double maxVal=0.0,aMax,sum=0.0,val;
        Integer[] nRow = new Integer[n-1];
        for(i=0;i<n-1;i++){
            maxVal=Math.abs(matrix[i][0]);
            for(j=0;j<n-1;j++){
                if(j==n-1)
                    bMatrix[i] = matrix[i][j];
                else{
                    if(maxVal < Math.abs(matrix[i][j]))
                        maxVal = Math.abs(matrix[i][j]); 
                }
            }
            s[i] = maxVal;
            if(s[i] == 0){
                throw new Exception("No enique solution exists !!!");  
            }
            nRow[i] = i+1;
        }
        i=1;
        while(flag == 1 && i <= n-2){
            iMax = nRow[i-1];
            aMax = Math.abs(matrix[iMax-1][i-1]) / s[iMax-1];
            iMax = i;
            for(j = i+1; j <= n-1; j++){
                if(Math.abs(matrix[nRow[j-1]-1][i-1]) / s[nRow[j-1]-1] > aMax){
                    aMax = Math.abs(matrix[nRow[j-1]-1][i-1]) / s[nRow[j-1]-1];
                    iMax = j;
                }
            }
            if(aMax <= ZERO){
                throw new Exception("No enique solution exists !!!");
            }
            else{

                if(!Objects.equals(nRow[i-1], nRow[iMax-1])){
                    temp= nRow[i-1];
                    nRow[i-1] = nRow[iMax-1];
                    nRow[iMax-1] = temp; 
                }
                for(j = i+1; j <= n-1; j++){ 
                    val = matrix[nRow[j-1]-1][i-1] / matrix[nRow[i-1]-1][i-1];
                    for(k = i+1; k<=n; k++)
                            matrix[nRow[j-1]-1][k-1] = matrix[nRow[j-1]-1][k-1] - val * matrix[nRow[i-1]-1][k-1];
                    matrix[nRow[j-1]-1][i-1] = 0.0;
                }
            }
            i++;
        }
        if(flag == 1){
            if(Math.abs(matrix[nRow[n-2]-1][n-2]) <= ZERO){
                throw new Exception("No enique solution exists !!!");
            }
            else{
                xMatrix[n-2] = matrix[nRow[n-2]-1][n-1] / matrix[nRow[n-2]-1][n-2];
                for(k=1;k <= n-2;k++){
                    i = n-2-k+1;
                    sum=0.0;
                    for(j = i+1; j <= n-1; j++)
                       sum = sum - matrix[nRow[i-1]-1][j-1] * xMatrix[j-1];
                    xMatrix[i-1] = (matrix[nRow[i-1]-1][n-1] + sum) / matrix[nRow[i-1]-1][i-1];
                }
            }
        }
    }
}
