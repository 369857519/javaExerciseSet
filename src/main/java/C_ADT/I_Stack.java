package C_ADT;

import java.util.Iterator;

/**
 * Created by qilianshan on 17/8/31.
 */
public class I_Stack<T> implements Iterable<T>{
    public Node<T> last;
    public Node<T> first;
    private int size;
    private int modCount;
    public I_Stack(){
        clear();
    }

    public Iterator<T> iterator() {
        return null;
    }
    
    public void push(T t){
        if(last==null){
            first=last=new Node<T>(t,null,null);
        }else{
            Node<T> current=new Node<T>(t,last,null);
            last.next=current;
            last=current;
        }
        size++;
        modCount++;
    }
    
    public T pop(){
        T data=null;
        if(last!=null){
            data=last.data;
            last=last.prev;
            if(last!=null){
                last.next=null;
            }
            size--;
            modCount++;
        }
        return data;
    }

    public String toString()
    {
        String str="";
        Node<T> current=first;
        while (current!=null){
            str=str+current.data+',';
            current=current.next;
        }
        str=str.substring(0,str.length()-1);
        return str;
    }

    private void clear(){
        last=null;
        size=0;
        modCount++;
    }

    private class Node<T>
    {
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

    public class myIterator implements Iterator<T>{

        public boolean hasNext() {
            return false;
        }

        public T next() {
            return null;
        }

        public void remove() {

        }
    }
}
