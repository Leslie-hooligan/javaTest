package bf;

import java.util.Random;

/**
 * @author 河南张国荣
 * @create 2022-01-01 19:28
 */
public class MatrixGenerator {

    public static double[][] generate(int rows,int columns){
        double[][] res =new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[i][j]=random.nextDouble()*10;
            }

        }
        return res;
    }
}
