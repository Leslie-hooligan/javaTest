package suanfa;


import java.util.Arrays;

/**
 * Shell排序
 */
public class Shell {

    private static void sort(Comparable[] a){
        int n = a.length;
        int h=n/3+1;
        //int h = 1 ;
        //while (h < n/3) h = 3*h + 1;
        while(h>=1){
            for(int i = h;i<n;i++){
                // 希尔排序和插入排序a[j].compareTo(a[j-h])<0判断条件一定要放在for循环的判断条件上，不能放在for循环体中
                // 因为被插入集合是一个有序集合，如果待插入元素比集合最后一个元素大，那就不用向前比较了。
                for(int j = i;j>=h&&a[j].compareTo(a[j-h])<0;j-=h){
                    Comparable t = a[j];
                    a[j]=a[j-h];
                    a[j-h]=t;
                }
            }
            h=h/3;
        }

    }

    public static void main(String[] args) {
        Integer[] a=new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            a[i]=(int)(Math.random()*10000000);
        }
        //137
        long l = System.currentTimeMillis();
        Shell.sort(a);
        System.out.println(System.currentTimeMillis()-l);
        System.out.println(Arrays.toString(a));
    }
}
