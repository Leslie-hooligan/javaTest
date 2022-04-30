package demo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author 河南张国荣
 * @create 2021-06-19 17:18
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -7763700527072968555L;

    //不变量初始不赋值
    private final String name;

    //构造函数为不变量赋值
    public Person() {
        name = "不变量赋值";
    }


    public static void main(String[] args) {
        // Integer[] date = {1, 2, 3, 4, 5};
        // List<Integer> list = Arrays.asList(date);
        //
        // list.add(1);
        // System.out.println("列表中的元素个数是：" + list.size());
        Person person = new Person();
        try {
            Object clone = person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
