package C_ADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by qilianshan on 17/8/14.
 */
public class CircularLinkedList<T> extends B_LinkedList{

    private int theSize;
    private int modCount=0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public CircularLinkedList(){
        clear();
    }

    public void clear(){
        beginMarker=new Node<T>(null,null,null);
        endMarker=new Node<T>(null,beginMarker,null);
        beginMarker.next=endMarker;
        theSize=0;
        modCount++;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private T remove(Node<T> p)
    {
        p.next.prev=p.prev;
        p.prev.next=p.next;
        theSize--;
        modCount++;

        return p.data;
    }
    private class MyIterator implements Iterator<T>{
        private Node<T> current=beginMarker.next;
        private int expectedmodCount=modCount;
        private boolean okToRemove=false;

        public boolean hasNext() {
            return true;
        }

        public T next() {
            if(modCount!=expectedmodCount)
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new NoSuchElementException();
            //如果链到了最后一个，则回到第一个
            if(current==endMarker){
                current=beginMarker;
            }
            T nextItem=current.data;
            current=current.next;
            okToRemove=true;
            return nextItem;
        }

        public void remove() {
            if(modCount!=expectedmodCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            CircularLinkedList.this.remove(current.prev);
            okToRemove=false;
            expectedmodCount++;
        }
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
