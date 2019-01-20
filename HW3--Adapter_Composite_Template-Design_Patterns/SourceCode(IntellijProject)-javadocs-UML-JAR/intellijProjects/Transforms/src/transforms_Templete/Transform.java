package transforms_Templete;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Transform islerini yapacak siniflarin turedikleri abstrack sinif.S
 * @author Yunus CEVIK
 */
public abstract class Transform {
    protected ArrayList<Double> dataItems = new ArrayList<>();

    protected ArrayList<Double> outreal = null;
    protected ArrayList<Double> outimag = null;

    /**
     * Override edilemeyen ve standart bir yapida calismasini saglayan metot.
     * @param inFileName Input olarak verilecek dosya ismi parametresi
     * @param outFileName Output olarak verilecek dosya ismi parametresi
     * @throws IOException WriteFile metotlarindan firlatilabilecek exception.
     */
    public final void translate(String inFileName, String outFileName) throws IOException {
        ReadFile(inFileName);
        Execution();
        WriteFile(outFileName);
        Hook();
    }

    /**
     * Dosyadan okunan verileri ArrayList icerisine ekleyen metot.
     * @param inFileName Input olarak verilecek dosya ismi parametresi
     * @throws FileNotFoundException Dosya bulunamadigi zaman firlatilan exception
     */
    private final void ReadFile(String inFileName) throws FileNotFoundException {
        File file = new File(inFileName);
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            dataItems.add(Double.parseDouble(scan.next()));
        }
    }

    /**
     * ArrayListlerin icerisindeki verileri dosyaya yazmaya yarayan metot.
     * @param outFileName Output olarak verilecek dosya ismi parametresi
     * @throws IOException Dosyaya yazamama hatasi firlatan exception
     */
    private final void WriteFile(String outFileName) throws IOException {
        FileWriter fileWriter = new FileWriter(outFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i = 0; i < dataItems.size(); i++) {
            if(outimag != null) {
                printWriter.printf("%10.5f\t%10.5fi\n", outreal.get(i), outimag.get(i));
                System.out.printf("%10.5f\t%10.5fi\n", outreal.get(i), outimag.get(i));
            }
            else{
                printWriter.printf("%10.5f\n",outreal.get(i));
                System.out.printf("%10.5f\n",outreal.get(i));
            }
        }
        printWriter.close();
    }

    /**
     * Donusum algoritmalarinin yazilmasi icin belirtilmis abstract metot.
     */
    protected abstract void Execution();
    protected abstract void Hook();



}
