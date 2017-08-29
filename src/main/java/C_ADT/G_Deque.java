package C_ADT;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by qilianshan on 17/8/29.
 */
public class G_Deque<T> implements Deque<T>{
    private Node<T> beginMarker;
    private Node<T> endMarker;
    private int modCount=0;
    private int size;

    public G_Deque()
    {
        clear();
    }

    public void clear()
    {
        beginMarker=new Node<T>(null,null,null);
        endMarker=new Node<T>(null,beginMarker,null);
        beginMarker.next=endMarker;
        size=0;
        modCount++;
    }
    public void addFirst(T t) {
        Node<T> n=new Node<T>(t,null,beginMarker);
        beginMarker.prev=n;
        beginMarker=n;
        size++;
        modCount++;
    }

    public void addLast(T t) {
        Node<T> n=new Node<T>(t,endMarker,null);
        endMarker.next=n;
        endMarker=n;
        size++;
        modCount++;
    }

    public T removeFirst() {
        T current=beginMarker.data;
        beginMarker=beginMarker.next;
        beginMarker.prev=null;
        size--;
        modCount++;
        return current;
    }

    public T removeLast() {
        T current=endMarker.data;
        endMarker=endMarker.prev;
        endMarker.next=null;
        size--;
        modCount++;
        return current;
    }

    private class Node<T>{
        public Node<T> prev;
        public Node<T> next;
        public T data;
        public Node(T d,Node<T> p,Node<T> n)
        {
            data=d;
            prev=p;
            next=n;
        }
    }
    public boolean offerFirst(T t) {
        return false;
    }

    public boolean offerLast(T t) {
        return false;

    }

    public T pollFirst() {
        return null;
    }

    public T pollLast() {
        return null;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public T peekFirst() {
        return null;
    }

    public T peekLast() {
        return null;
    }

    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    public boolean add(T t) {
        return false;
    }

    public boolean offer(T t) {
        return false;
    }

    public T remove() {
        return null;
    }

    public T poll() {
        return null;
    }

    public T element() {
        return null;
    }

    public T peek() {
        return null;
    }

    public void push(T t) {

    }

    public T pop() {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    private class DequeIterator implements Iterator<T>
    {

        public boolean hasNext() {
            return false;
        }

        public T next() {
            return null;
        }

        public void remove() {

        }
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public Iterator<T> descendingIterator() {
        return null;
    }
}
