package suanfa;

import java.util.Arrays;

/**
 * 归并排序自底向上的实现
 */
public class MergeSort2 {

    private static Comparable[] aux;

    private static void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        int N = a.length;
        for (int az = 1; az < N; az = az + az) {
            for (int k = 0; k < N - az; k = k + az + az) {
                merge(a, k, k + az - 1, Math.min(k + az + az - 1, N - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) > 0) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[1000000];
        for (int i = 0; i < 1000000; i++) {
            a[i] = (int) (Math.random() * 10000000);
        }
        //137
        long l = System.currentTimeMillis();
        MergeSort2.sort(a);
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(Arrays.toString(a));
    }
}
