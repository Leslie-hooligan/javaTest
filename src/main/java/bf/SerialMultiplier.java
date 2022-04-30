package bf;

import java.util.Date;

/**
 * @author 河南张国荣
 * @create 2022-01-01 19:40
 */
public class SerialMultiplier {

    public static double[][] multiply(double[][] matrix1,double[][] matrix2,double[][] res){
        int rows1 =matrix1.length;
        int column1=matrix1[0].length;
        int column2=matrix2[0].length;
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < column2; j++) {
                res[i][j]=0;
                for (int k = 0; k < column1; k++) {
                    res[i][j]+=matrix1[i][k]*matrix2[k][j];
                    
                }
                
            }
        }


        return res;
    }

    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(500, 500);
        double matrix2[][] = MatrixGenerator.generate(500, 500);
        double resultSerial[][]= new double[matrix1.length][matrix2[0].length];
        Date start=new Date();
        SerialMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        // 312
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }
}
