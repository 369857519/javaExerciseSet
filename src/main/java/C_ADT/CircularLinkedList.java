package C_ADT;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by qilianshan on 17/8/14.
 */
public class CircularLinkedList<E> implements Iterable<E>{

    private Node<E> beginMarker;
    private Node<E> endMarker;
    private int theSize;
    private int modCount;

    public Iterator<E> iterator() {
        return null;
    }
    private static class Node<T>
    {
        public Node(T d,Node<T> p,Node<T> n)
        {
            data=d;
            prev=p;
            next=n;
        }
        public T data;
        public Node<T> prev;
        public Node<T> next;
    }
}
