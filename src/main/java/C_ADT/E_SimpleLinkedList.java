package C_ADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by qilianshan on 17/8/22.
 */
public class E_SimpleLinkedList<T> implements Iterable<T> {

    ublic int theSize;
    public int modCount=0;
    public Node<T> entry=null;

    public E_SimpleLinkedList()
    {
        clear();
    }

    public void clear()
    {
        entry=null;
        theSize=0;
        modCount++;
    }

    public int size()
    {
        return theSize;
    }

    public boolean isEmpty()
    {
        return size()==0;
    }

    public boolean add(T x)
    {
        add(size(),x);return true;
    }

    public boolean add(int idx,T x)
    {
        addBefore(getNode(idx),x);
        return true;}

    public T get (int idx)
    {
        return getNode(idx).data;
    }

    public T set(int idx,T newVal)
    {
        Node<T> p=getNode(idx);
        T oldVal=p.data;
        p.data=newVal;
        return oldVal;
    }

    private void addBefore(Node<T> p,T x)
    {
        Node<T> newNode=new Node<T>(x,p.prev,p);
        newNode.prev.next=newNode;
        p.prev=newNode;
        theSize++;
        modCount++;
    }

    public boolean contains(T data)
    {
        Node<T> currentIt=beginMarker;
        while (currentIt!=null){
            if(currentIt.data==data){
                return true;
            }
            currentIt=currentIt.next;
        }
        return false;
    }

    private T remove(Node<T> p)
    {
        p.next.prev=p.prev;
        p.prev.next=p.next;
        theSize--;
        modCount++;

        return p.data;
    }



    private Node<T> getNode(int idx)
    {
        Node<T> p;
        if(idx<0||idx>size())
            throw new IndexOutOfBoundsException();

        if(idx<size()/2)
        {
            p=beginMarker.next;
            for(int i=0;i<idx;i++)
                p=p.next;
        }
        else
        {
            p=endMarker;
            for(int i=size();i>idx;i--)
                p=p.prev;
        }
        return p;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
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

    private class LinkedListIterator implements Iterator<T>
    {
        private Node<T> current=beginMarker.next;
        private int expectedModCount=modCount;
        private boolean okToRemove=false;

        public boolean hasNext() {
            return current!=endMarker;
        }
        public T next() {
            if(modCount!=expectedModCount)
                throw new ConcurrentModificationException();
            //变成循环链表
            if(current==endMarker){
                current=beginMarker.next;
            }
            T nextItem=current.data;
            current=current.next;
            okToRemove=true;
            return nextItem;
        }

        public void remove() {
            if(modCount!=expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            E_SimpleLinkedList.this.remove(current.prev);
            okToRemove=false;
            expectedModCount++;
        }
    }
}
