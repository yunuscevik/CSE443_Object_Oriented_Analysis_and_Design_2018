package gokturkthreesatalite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator arayuzunden implement edilerek hasNext ve Next gibi metotlarin implementini saglayan abstract siniftir.
 * @author Yunus CEVIK
 */
public abstract class SpirallyIterator implements Iterator {

    protected ArrayList<Integer> arr;
    protected Iterator<Integer> iter = null;
    protected int Size;
    protected int innerSize;
    protected int row = 0;
    protected int col = 0;

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Object next() {
        return iter.next();
    }
}
