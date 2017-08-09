package A_Introduction;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by qilianshan on 17/7/26.
 */
public class MyCollection<E extends Comparable> implements Collection<E> {
    public static void main(String[] args) throws InstantiationException,IllegalAccessException{
        MyCollection<Integer> m=new MyCollection<Integer>(100);
        m.add(1);m.add(3);m.add(5);
        System.out.print(m.findMax());
        System.out.println(m.findMin());
    }
    MyCollection (int size) throws InstantiationException,IllegalAccessException{
        this.size=size;

    }
    private E[] inn=null;
    private int size=0;
    public int size()
    {
        return this.size;
    }
    public boolean isEmpty() {

        return this.size()==0;
    }


    public boolean makeEmpty(){
        return this.removeAll(this);
    }

    public boolean insert(E a){
        return this.add(a);
    }

    public E findMin(){
        if(this.size()==0){
            return null;
        }
        E minElem=inn[0];
        for(int i=1;i<this.size;i++){
            if(inn[i].compareTo(minElem)>0){
                minElem=inn[i];
            }
        }
        return minElem;
    }

    public E findMax(){
        if(this.size()==0){
            return null;
        }
        E maxElem=inn[0];
        for(int i=0;i<this.size;i++){
            if(inn[i].compareTo(maxElem)<0){
                maxElem=inn[i];
            }
        }
        return maxElem;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public <T> T[] toArray(T[] a) {
        System.arraycopy(inn,0,a,0,inn.length);
        return a;
    }

    public E[] toArray(){
        return inn;
    }

    public boolean add(E e) {
        if(inn.length>=this.size+1){
            inn[this.size()+1]=e;
            this.size++;
            return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public void clear() {

    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {

        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }
}
