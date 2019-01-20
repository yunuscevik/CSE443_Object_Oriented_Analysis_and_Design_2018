package transforms_Templete;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DFT ve DCT algoritmalarinin bulunduklari siniflardan obje olusturarak input dosyasindaki verilerden,
 * output dosyasina donusumlerinin yapilmasi icin olusturulmus main sinifi.
 * @author Yunus CEVIK
 */
public class Main {
    public static void main(String[] args){
        try {
            System.out.println("Discrete Fourier Transform");
            Transform dft = new DFT();
            dft.translate("src/Data.txt", "src/DFT_Ourput.txt");
            System.out.println("\n------------------------------------------------------------\n");
            System.out.println("Discrete Cosine Transform");
            Transform dct = new DCT();
            dct.translate("src/Data.txt","src/DCT_Ourput.txt" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}