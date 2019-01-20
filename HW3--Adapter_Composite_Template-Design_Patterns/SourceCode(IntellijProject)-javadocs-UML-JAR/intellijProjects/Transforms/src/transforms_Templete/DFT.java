package transforms_Templete;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract olan Transform sinfindan extends edilmis Discrete Fourier Transform sinifi.
 * @author Yunus CEVIK
 */
public class DFT extends Transform {

    private long firstTime;
    private double inImag = 0;

    /**
     * Discrete Fourier Transform Constructor
     */
    public DFT(){
        outreal = new ArrayList<>();
        outimag = new ArrayList<>();
    }

    /**
     * Discrete Fourier Transform formulu ile yazilmis olan metot
     */
    @Override
    public void Execution() {
        firstTime = System.currentTimeMillis();

        int N = dataItems.size();
        for (int k = 0; k < N; k++) {
            double sumreal = 0;
            double sumimag = 0;
            for (int t = 0; t < N; t++) {
                double angle = 2 * Math.PI * t * k / N;
                sumreal += dataItems.get(t) * Math.cos(angle) + inImag * Math.sin(angle);
                sumimag += -dataItems.get(t) * Math.sin(angle) + inImag * Math.cos(angle);
            }
            outreal.add(sumreal);
            outimag.add(sumimag);
        }
    }

    /**
     * Kullanicidan Discrete Fourier Transform algoritmasinin ne kadar surede calistigini soran metot.
     */
    @Override
    public void Hook() {
        System.out.println("\n\nWould you like to learn time of execution? (y / PRESS ANY KEY)");
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        if(key.equals("y") || key.equals("Y") || key.equals("yes") || key.equals("YES") || key.equals("Yes")){
            System.out.println("\nTime of execution of Discrete Fourier Transform : " + (System.currentTimeMillis()- firstTime) + " Millis");
        }
    }
}
