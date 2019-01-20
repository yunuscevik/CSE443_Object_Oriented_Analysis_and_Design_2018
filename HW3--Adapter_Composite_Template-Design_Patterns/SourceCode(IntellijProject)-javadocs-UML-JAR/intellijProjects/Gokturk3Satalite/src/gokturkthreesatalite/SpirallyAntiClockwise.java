package gokturkthreesatalite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * SpirallyIteraor sinifindan extends edilerek, Iki boyutlu dizi uzerinde saat yonunun tersine gezinerek bir ArrayList'e ekler ve ekrana basilmasini saglar.
 * @author Yunus CEVIK
 */
public class SpirallyAntiClockwise extends SpirallyIterator {

    public SpirallyAntiClockwise(Integer[][] data){
        arr = new ArrayList<>();
        Size = data.length;
        innerSize = data[0].length;
        while (Size > 0 && innerSize > 0){
            if(Size == 1){
                for (int i = 0; i < innerSize; i++)
                    arr.add(data[row++][col]);
                break;
            }
            else if(innerSize == 1){
                for (int i = 0; i < Size; i++)
                    arr.add(data[row][col++]);
                break;
            }
            for (int i = 0; i < innerSize-1; i++)
                arr.add(data[row++][col]);
            for (int i = 0; i < Size-1; i++)
                arr.add(data[row][col++]);
            for (int i = 0; i < innerSize-1; i++)
                arr.add(data[row--][col]);
            for (int i = 0; i < Size-1; i++)
                arr.add(data[row][col--]);
            row++;
            col++;
            Size = Size-2;
            innerSize = innerSize-2;
        }
        iter = arr.iterator();
    }
}
