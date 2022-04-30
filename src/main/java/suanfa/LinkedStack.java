package suanfa;

import java.util.Iterator;

/**
 * 栈的链表实现
 * @author 河南张国荣
 * @create 2020-12-20 17:19
 */
public class LinkedStack<T> implements Iterable<T> {


    // 头节点
    private Node first;
    // 链表长度
    private int n;
    // Node内部类
    private class Node{
        T val;
        Node next;
    }
    // 入栈
    public void push(T t){
        Node oldFirst=first;
        first=new Node();
        first.val=t;
        first.next=oldFirst;
        n++;
    }
    // 出栈
    public T pop(){
        if(isEmpty()){
            return null;
        }
        T t=first.val;
        first=first.next;
        n--;
        return t;
    }
    // 栈的大小
    public int size(){
        return n;
    }
    // 栈是否为空
    public boolean isEmpty(){
       return n==0;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node i=first;
            @Override
            public boolean hasNext() {
                return i!=null;
            }

            @Override
            public T next() {
                T t= i.val;
                i=i.next;
                return t;
            }
        };
    }

    public static void main(String[] args) {
        LinkedStack<Integer> ints = new LinkedStack<>();

        ints.push(111);
        ints.push(222);
        ints.push(333);
        ints.push(444);
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
