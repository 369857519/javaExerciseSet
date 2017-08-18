package C_ADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by qilianshan on 17/8/17.
 */
public class D_SingleList<T> implements Iterable<T> {
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

    private Node<T> getNodePrev(int idx){
        Node<T> p;
        if(idx<0||idx>size())
            throw new IndexOutOfBoundsException();

        p=beginMarker;
        for(int i=0;i<idx;i++)
            p=p.next;
        return p;
    }

    public String toString(){
        Iterator<T> it=iterator();
        String str="";
        while (it.hasNext())
        {
            str+=it.next().toString();
        }

        return str;
    }

    public boolean contains(T d){
        Iterator<T> it=iterator();
        while (it.hasNext())
        {
            if(it.next()==d){
                return true;
            }
        }
        return false;
    }

    public boolean add(T x)
    {
        add(size(),x);return true;
    }

    public void add(int idx,T x){
        addAfter(getNodePrev(idx),x);
    }

    private void addAfter(Node<T> p,T x)
    {
        Node<T> newNode=new Node<T>(x,null);
        p.next=newNode;
        theSize++;
        modCount++;
    }

    public boolean addIfNotContains(T d){
        if(!contains(d)){
            add(d);
        }
        return true;
    }

    public T remove(int idx)
    {
        return remove(getNodePrev(idx));
    }

    public T remove(Node<T> p)
    {
        T data=p.next.data;
        p.next=p.next.next;
        theSize--;
        modCount++;
        return data;
    }

    public Boolean ifContainsDelete(T d){
        if(contains(d)){
            Iterator<T> it=iterator();
            while(it.hasNext()){
                if(it.next()==d){
                    it.remove();
                }
            }
        }
        return true;
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
            D_SingleList.this.remove(current);
            okToRemove=false;
            expectedModCount++;
        }
    }

    private static class Node<T>
    {
        public T data;
        public Node<T> next;
        public Node(T d,Node<T> n)
        {
            data=d;
            next=n;
        }
    }
}
