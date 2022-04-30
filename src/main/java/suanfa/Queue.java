package suanfa;

import java.util.Iterator;

/**
 * 先进先出队列(链表实现)
 * @author 河南张国荣
 * @create 2020-12-20 20:29
 */
public class Queue<T> implements Iterable<T> {

    // 头节点
    private Node first;
    // 尾节点
    private Node last;
    // 队列大小
    private int n;
    // Node节点
    private class Node{
        T val;
        Node next;
    }
    // 判断是否为空
    public boolean isEmpty(){
        return first==null;
    }

    // 队列大小
    public int size(){
        return n;
    }
    // 入队
    public void enqueue(T t){
        Node oldLast = last;
        last=new Node();
        last.val=t;
        if(isEmpty()){
            first=last;
        }else {
            oldLast.next=last;
        }
        n++;
    }
    // 出队
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        T t=first.val;
        first=first.next;
        if(isEmpty()){
            last=null;
        }
        n--;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node i =first;
            @Override
            public boolean hasNext() {
                return i!=null;
            }

            @Override
            public T next() {
                T t=i.val;
                i=i.next;
                return t;
            }
        };
    }

    public static void main(String[] args) {
        Queue<Integer> integers = new Queue<>();
        integers.enqueue(111);
        integers.enqueue(222);
        integers.enqueue(333);
        integers.enqueue(444);
        integers.enqueue(555);
        System.out.println(integers.first.next.val);
        System.out.println(integers.size());
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        Integer dequeue = integers.dequeue();
        System.out.println(dequeue);
        System.out.println(integers.size());
    }
}
