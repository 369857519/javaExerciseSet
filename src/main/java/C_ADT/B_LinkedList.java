package C_ADT;

import com.sun.xml.internal.bind.AnyTypeAdapter;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by qilianshan on 17/8/9.
 */
public class B_LinkedList<T> implements Iterable<T> {

    public B_LinkedList()
    {
        clear();
    }

    public void clear()
    {
        beginMarker=new Node<T>(null,null,null);
        endMarker=new Node<T>(null,beginMarker,null);
        beginMarker.next=endMarker;
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
    public boolean swap(int idx1,int idx2)
    {
        if(idx1>0&&idx1<size()&&idx2>0&&idx2<size()&&idx1==idx2-1)
        {
            Node<T> node1=getNode(idx1);
            Node<T> node2=getNode(idx2);
            node2.prev=node1.prev;
            node2.prev.next=node2;
            node1.next=node2.next;
            node1.next.prev=node1;
            node1.prev=node2;
            node2.next=node1;
            return true;
        }
        return false;
    }

    public T remove(int idx)
    {
        return remove(getNode(idx));
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

    public int theSize;
    public int modCount=0;
    public Node<T> beginMarker;
    public Node<T> endMarker;

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
            System.out.print(current.prev.data);

            B_LinkedList.this.remove(current.prev);
            okToRemove=false;
            expectedModCount++;
        }
    }

}
