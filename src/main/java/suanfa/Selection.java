package suanfa;

import java.util.Arrays;
import java.util.Random;

/**
 *   选择排序
 */
public class Selection {

    public static void sort(Comparable[] a){
        int n = a.length;
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(a[j].compareTo(a[min])<0){
                    min=j;
                }
            }

            Comparable t=a[min];
            a[min]=a[i];
            a[i]=t;
        }
    }

    public static void main(String[] args) {
        Integer[] a=new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            a[i]=(int)(Math.random()*10000000);
        }
        // 172 13 971
        long l = System.currentTimeMillis();
        Selection.sort(a);
        System.out.println(System.currentTimeMillis()-l);
        System.out.println(Arrays.toString(a));
    }

}
