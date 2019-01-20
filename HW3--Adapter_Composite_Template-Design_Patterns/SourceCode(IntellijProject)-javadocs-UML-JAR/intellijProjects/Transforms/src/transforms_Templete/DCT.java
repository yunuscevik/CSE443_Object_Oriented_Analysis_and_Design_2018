package transforms_Templete;

import java.util.ArrayList;

/**
 * Abstract olan Transform sinfindan extends edilmis Discrete Cosine Transform sinifi.
 * @author Yunus CEVIK
 */
public class DCT extends Transform {
    /**
     * Discrete Cosine Transform Constructor
     */
    public DCT(){
        outreal = new ArrayList<>();
    }

    /**
     * Discrete Cosine Transform formulu ile yazilmis olan metot
     */
    @Override
    public void Execution() {
        double factor = Math.PI/ dataItems.size();
        for (int i = 0; i < dataItems.size(); i++) {
            double sumreal = 0;
            for (int j = 0; j < dataItems.size(); j++) {
                sumreal += dataItems.get(j) * Math.cos((j + 0.5) * i * factor);
            }
            outreal.add(sumreal);
        }
    }

    @Override
    public void Hook() {
        return;
    }
}
