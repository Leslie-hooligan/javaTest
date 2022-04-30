package suanfa;


import java.util.Iterator;

/**
 * 下 压 （U F O )栈 （能够动态调整数组大小的实现)
 * @author 河南张国荣
 * @create 2020-12-19 17:41
 */
public class ArrayStack<T> implements Iterable<T> {

    // 创建一个数组用于存储元素
    private T[] item = (T[]) new Object[1];
    // 定义一个指向栈顶的指针
    private int top = 0;
    // 入栈
    public void push(T t){
        if(top == item.length){
            resize(2*item.length);
        }
        item[top++]=t;
    }
    // 出栈
    public T pop(){
        if(isEmpty()){
            return null;
        }
         T t=item[--top];
        // 将出栈元素的指针设置为空，目的是让垃圾回收器可以回收出栈的元素
        item[top]=null;
        if(top<item.length/4){
            resize(item.length/2);
        }
        return t;
    }
    // 判断栈是否为空
    public boolean isEmpty(){
        return  top == 0;
    }
    // 栈动态扩容
    public void resize(int max){
            // 将栈移动到大小为max的新数组
            T[] a= (T[]) new Object[max];
            for(int i=0;i<top;i++){
                a[i]=item[i];
            }
            item=a;
    }
    // 栈的大小
    public int size(){
        return top;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int a=top;
            @Override
            public boolean hasNext() {
                return a>0;
            }

            @Override
            public T next() {
                return item[--a];
            }
        };
    }

    public static void main(String[] args) {
        ArrayStack<Integer> ints = new ArrayStack<>();

        ints.push(111);
        ints.push(222);
        ints.push(444);
        ints.push(333);
        ints.push(555);
        System.out.println(ints.size());
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
        Integer pop = ints.pop();
        System.out.println(pop);

        System.out.println(ints.size());


    }
}
