import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by zhao on 2018/9/3.
 */
public class MyLinkedList<T> {
    private Node first;
    private Node last;
    private int size;
    private int modCount=0;

    private static class Node<T>
    {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        Node(Node<T> prev,T element,Node<T> next)
        {
            this.item=element;
            this.next=next;
            this.prev=prev;
        };
    }
    public MyLinkedList(){
        clear();
    }
    public void clear(){
        doClear();
    }
    private void doClear(){
        first =new Node<T>(null,null,null);
        last=new Node<T>(first,null,null);
        first.next=last;
        size=0;
        modCount++;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean add(T t){
        addBefore(last,t);
        return true;
    }
    public void add(int index,T t){
        addBefore(getNode(index,0,size),t);
    }
    public T get(int index){
        return getNode(index).item;
    }
    public T set(int index,T t){
        Node<T> p=getNode(index);
        T old=p.item;
        p.item=t;
        return old;
    }
    public T remove(int index){
        return remove(getNode(index));
    }
    private T remove(Node<T> p){
        p.prev.next =p.next;
        p.next.prev=p.prev;
        size--;
        modCount++;
        return p.item;
    }
    public void addBefore(Node<T> p,T t)
    {
        p.prev=p.prev.next=new Node<T>(p.prev,t,p);
        size++;
        modCount++;
    }
    private Node<T> getNode(int index){
        return getNode(index,0,size-1);
    }
    private Node<T> getNode(int index,int lower,int upper){
        if(index <lower || index >upper)
        {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p;
        if(index <size /2){
            p=first.next;
            for(int i=0;i<index;i++)
            {
                p=p.next;
            }
        }
        else
        {
            p=last;
            for(int i=size;i>index;i--)
            {
                p=p.prev;
            }
        }
        return p;
    }
    public String toString(){
        StringJoiner str=new StringJoiner(",","[","]");
        Node<T> p=first.next;
        while(p!= last)
        {
            str.add(p.item.toString());
            p=p.next;
        }
        return str.toString();
    }
    public static void main(String[] args)
    {
        LinkedList<String> l1=new LinkedList<String>();
        l1.add("hello");
        l1.add("world");
        l1.addFirst("zyc");
        l1.addLast("over");
        l1.remove(3);
        System.out.println(l1.getFirst());
        System.out.println(l1.toString());

    }

}
