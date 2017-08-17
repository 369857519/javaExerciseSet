package C_ADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by qilianshan on 17/8/17.
 */
public class D_SingleList<T> extends Iterable<T> {
    public int theSize;
    public int modCount=0;
    public Node<T> beginMarker;

    public void clear()
    {
        beginMarker=new Node<T>(null,null);
        beginMarker.next=null;
        theSize=0;
        modCount++;
    }

    public int size()
    {
        return theSize;
    }

    private Node<T> getNode(int idx){
        Node<T> p;
        if(idx<0||idx>size())
            throw new IndexOutOfBoundsException();

        if(idx<size()/2)

    }

    public T remove(int idx)
    {
        return remove(getNode(idx));
    }

    public String toString(){
        String s="";

        return s;
    }
    public Iterator<T> iterator() {
        return null;
    }

    private class myIterator implements Iterator<T>{
        private Node<T> current=beginMarker.next;
        private int expectedModCount=modCount;
        private boolean okToRemove=false;

        public boolean hasNext() {
            return current.next==null;
        }

        public T next() {
            if(modCount!=expectedModCount)
                throw new ConcurrentModificationException();
            T nextItem=current.data;
            current=current.next;
            okToRemove=true;
            return nextItem;
        }

        public void remove(){
            if(modCount!=expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();

            return D_SingleList.this.remove(current);
            okToRemove=false;
            expectedModCount++;
        }

        public void remove() {

        }
    }

    private static class Node<T>
    {
        public T data;
        public Node<T> next;
        public Node(T d,Node<T> p)
        {
            data=d;
            prev=p;
        }
    }
}
