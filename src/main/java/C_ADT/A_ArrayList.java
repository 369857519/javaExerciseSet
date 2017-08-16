package C_ADT;

import java.util.*;

/**
 * Created by qilianshan on 17/8/9.
 */
public class A_ArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY=10;

    private int theSize;
    private T[] theItems;

    public A_ArrayList()
    {
        clear();
    }

    public void clear()
    {
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty()
    {
        return size()==0;
    }

    public void trimToSize()
    {
        ensureCapacity(size());
    }

    public T get(int idx)
    {
        if(idx<0||idx>=size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public T set(int idx,T newVal)
    {
        if(idx<0||idx>=size())
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old=theItems[idx];
        theItems[idx]=newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity)
    {
        if(newCapacity<theSize)
            return;

        T[] old=theItems;
        theItems=(T[])new Object[newCapacity];
        for(int i=0;i<size();i++)
            theItems[i]=old[i];
    }

    public boolean add(T x)
    {
        add(size(),x);
        return true;
    }
    public void add(int idx,T x)
    {
        if(theItems.length==size())
            ensureCapacity(size()*2+1);
        for(int i=theSize;i>idx;i--)
            theItems[i]=theItems[i-1];
        theItems[idx]=x;

        theSize++;
    }
    public void addAll(Iterable<? extends T> items)
    {
        for(T item:items)
        {
            add(item);
        }
    }
    public T remove(int idx)
    {
         T removedItem=theItems[idx];
        for(int i=idx;i<size()-1;i++)
            theItems[i]=theItems[i+1];
        theSize--;
        return removedItem;
    }
    public void removeAll(Iterable<? extends T> items){
        ArrayList<Integer> list=new ArrayList<Integer>();
        //o(n^2)
        for(T item:items){
            for(int i=0;i<theSize;i++)
            {
                if(this.get(i).equals(item)){
                    list.add(i);
                }
            }
        }
        //去重o(n)
        Set temSet=new HashSet(list);
        list=new ArrayList<Integer>(temSet);
        //排序o(n*lgn)
        Collections.sort(list);

        //o(n^2)
        for(int i=list.size()-1;i>=0;i--){
            this.remove(list.get(i));
        }
    }
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator<T>
    {
        private int current=0;

        public boolean hasNext() {
            return current<size();
        }

        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }

        public void remove() {
            A_ArrayList.this.remove(--current);
        }
    }
//        boolean modified = false;
//        Iterator<?> e = iterator();
//           while (e.hasNext()) {
//                if (c.contains(e.next())) {
//                         e.remove();
//                         modified = true;
//                }
//        }
//        return modified;
}
