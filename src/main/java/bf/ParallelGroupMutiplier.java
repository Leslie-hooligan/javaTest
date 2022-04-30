package bf;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 河南张国荣
 * @create 2022-01-01 20:10
 */
public class ParallelGroupMutiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] res) {
        ArrayList<Thread> threads = new ArrayList<>();
        int num = matrix1.length;
        int i = Runtime.getRuntime().availableProcessors();
        int temp = num / i;
        int start = 0;
        int end = temp;
        for (int j = 0; j < i; j++) {
            Thread thread = new Thread(new GroupMultiplierTask(res, matrix1, matrix2, start, end));
            thread.start();
            threads.add(thread);
            start = end;
            end=j==i-2?num:end+temp;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(500, 500);
        double matrix2[][] = MatrixGenerator.generate(500, 500);
        double resultSerial[][]= new double[matrix1.length][matrix2[0].length];
        Date start=new Date();
        ParallelGroupMutiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        // 125
        System.out.printf("Parallel: %d%n",end.getTime()-start.getTime());
    }
}
