package suanfa;

import java.util.Arrays;

/**
 * 归并排序的自顶向下的实现
 */
public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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
        Integer[] a = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = (int) (Math.random() * 10000000);
        }
        //137
        long l = System.currentTimeMillis();
        MergeSort.sort(a);
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(Arrays.toString(a));
    }

}
