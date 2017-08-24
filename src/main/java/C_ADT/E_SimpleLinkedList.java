package C_ADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by qilianshan on 17/8/22.
 */
public class E_SimpleLinkedList<T> implements Iterable<T> {

    public int theSize;
    public int modCount=0;
    public Node<T> beginMarker;
    public Node<T> endMarker;

    public E_SimpleLinkedList()
    {
        beginMarker=null;
        endMarker=null;
        theSize=0;
        modCount++;
    }

    public E_SimpleLinkedList(T t)
    {
        clear(t);
    }

    public void clear(T t)
    {
        beginMarker=new Node<T>(t,null,null);
        endMarker=beginMarker;
        theSize=1;
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
        if(size()==0){
            clear(x);
        }else{
            add(size()+1,x);
        }
        return true;
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
        Node<T> newNode;
        //如果插的位置是尾节点
        if(p==null){
            newNode=new Node<T>(x,endMarker,null);
            newNode.prev.next=newNode;
            endMarker=newNode;
        }else if(p==beginMarker){
            //如果插的是头节点
            newNode=new Node<T>(x,p.prev,p);
            newNode.next.prev=newNode;
            beginMarker=newNode;
        }else{
            newNode=new Node<T>(x,p.prev,p);
            newNode.prev.next=newNode;
            p.prev=newNode;
        }
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
        if(theSize==1){
            beginMarker=endMarker=null;
        }
        if(p.next!=null) p.next.prev=p.prev;
        else endMarker=p.prev;
        if(p.prev!=null) p.prev.next=p.next;
        else beginMarker=p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    public T lazyRemove(Node<T> p)
    {
        p.deleted=true;
        theSize--;
        return p.data;
    }

    private Node<T> getNode(int idx)
    {
        Node<T> p;
        if(idx<0||idx>size())
            return null;

        if(idx<size()/2)
        {
            p=beginMarker;
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
            deleted=false;
        }
        public T data;
        public Node<T> prev;
        public Node<T> next;
        public boolean deleted;
        public String toString(){
            return data.toString();
        }
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

    private class LinkedListIterator implements Iterator<T>
    {
        private Node<T> current=beginMarker;
        private int expectedModCount=modCount;
        private boolean okToRemove=false;

        public LinkedListIterator(){
            if(beginMarker!=null){
                okToRemove=true;
            }
        }

        public boolean hasNext() {
            if(current!=null){
                //如果下一个存在,则进行遍历
                while (current.deleted){
                    if(current.next==null){
                        return !current.deleted;
                    }
                    current=current.next;
                    //直到遍历到最后一个
                }
            }

            return current!=null;
        }
        public T next() {
            if(modCount!=expectedModCount)
                throw new ConcurrentModificationException();
            if(current==null){
                throw new IndexOutOfBoundsException();
            }

            T nextItem=current.data;
            current=current.next;
            if(current!=null){
                if(current.deleted)next();
            }
            okToRemove=true;
            return nextItem;
        }

        public void remove() {
            if(modCount!=expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            if(current==null){
                throw new IndexOutOfBoundsException();
            }
            E_SimpleLinkedList.this.lazyRemove(current);
            okToRemove=false;
            expectedModCount++;
        }
    }
}
