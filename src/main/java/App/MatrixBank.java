package App;

import java.util.ArrayList;
import java.util.List;

import fundament.RealMatrix;

public class MatrixBank {
    
    public static List<RealMatrix> createMatrices() {
        List<RealMatrix> matrices = new ArrayList<>();


        matrices.add(new RealMatrix(
            3,3,
            0,  0,  1,
            4,  1, 12,
            1,  0,  3
        ));


        matrices.add(new RealMatrix(3,3,
            1, 0, 2,
            0, 0, 1,
            1, 1, 2
        ));

        matrices.add(new RealMatrix(3,3,
            0,  0,  1,
            2,  1,  6,
            1,  0,  3
        ));

        matrices.add(new RealMatrix(3,3,
            1,  1,  1,
            0,  1,  2,
            0, -1, -1
        ));

        matrices.add(new RealMatrix(3,3,
            0,  1, -1,
            1,  1,  0,
            0,  2, -1
        ));

        matrices.add(new RealMatrix(3,3,
             1,  4, -2,
             3,  0,  1,
             2,  1,  0
        ));

        matrices.add(new RealMatrix(3,3,
            1,  0,  2,
            1,  1,  2,
           -1, -1, -1
        ));

        matrices.add(new RealMatrix(3,3,
            1, 1, 0,
            0, 1, 2,
            1, 1, 1
        ));

        matrices.add(new RealMatrix(3,3,
            1, 3,  0,
            0, 1, -1,
            1, 3,  1
        ));

        matrices.add(new RealMatrix(3,3,
            1, 1, 0,
            0, 1,-1,
            2, 2, 1
        ));
        return matrices;
    }
}
