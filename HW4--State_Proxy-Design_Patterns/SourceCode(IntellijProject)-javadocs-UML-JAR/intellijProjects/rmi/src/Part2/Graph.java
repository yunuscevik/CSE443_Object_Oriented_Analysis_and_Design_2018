package Part2;

import java.io.Serializable;

public interface Graph extends Serializable {
    Edge[] getEdges();
    double getWeight(int from, int to);
    int getV();
}
