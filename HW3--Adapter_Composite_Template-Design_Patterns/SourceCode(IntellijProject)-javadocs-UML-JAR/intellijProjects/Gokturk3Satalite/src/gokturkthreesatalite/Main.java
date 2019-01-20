package gokturkthreesatalite;

/**
 * Iki boyutlu diziyi saat yonunde veya saat yonunun tersine gezinerek ekrana basan kod bloklarinin main fonksiyonu.
 * @author Yunus CEVIK
 */
public class Main {
    public static void main(String[] args) {
        int row = 4;
        int col = 4;
        int count = 0;
        Integer[][] data = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i][j] = ++count;
            }
        }
        System.out.println("Data : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("\nThe first iterator: ");
        SpirallyIterator spirallyClockwise = new SpirallyClockwise(data);
        while (spirallyClockwise.hasNext()){
            System.out.print(spirallyClockwise.next() + " ");
        }

        System.out.print("\nThe second iterator: ");
        SpirallyIterator spirallyAntiClockwise = new SpirallyAntiClockwise(data);
        while (spirallyAntiClockwise.hasNext()){
            System.out.print(spirallyAntiClockwise.next() + " ");
        }
    }
}
