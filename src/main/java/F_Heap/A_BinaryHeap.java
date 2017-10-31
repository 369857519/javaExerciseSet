package F_Heap;

import java.nio.BufferUnderflowException;

/**
 * Created by qilianshan on 17/10/31.
 */
public class A_BinaryHeap<T extends Comparable<? super T>> {
    public A_BinaryHeap(){
        this((T[])new Comparable[DEFAULT_CAPACITY]);
    }

    public A_BinaryHeap(int capacity)
    {
        this((T[])new Comparable[capacity]);
    }

    public A_BinaryHeap(T[] items)
    {
        currentSize=items.length;
        array=(T[])new Comparable[(currentSize+2)*11/10];
        int i=1;
        for(T item:items)
            array[i++]=item;
        buildHeap();
    }

    public void insert(T x)
    {
        if(currentSize==array.length-1)
            enlargeArray(array.length*2+1);

        int hole=++currentSize;

        for(;hole>1&&x.compareTo(array[hole/2])<0;hole/=2){
            //比对父节点，如果小于父节点，此时的位置等于父节点，继续下滤，
            array[hole]=array[hole/2];
        }
        array[hole]=x;
    }

    public T deleteMin()
    {
        if(isEmpty())
            throw new BufferUnderflowException();
        T minItem=findMin();
        array[1]=array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public T findMin(){
        if(currentSize<0){
            throw new BufferUnderflowException();
        }
        return array[1];
    }

    public boolean isEmpty(){
        return currentSize<=0;
    }

    private void percolateDown(int hole)
    {
        int child;
        T tmp=array[hole];

        for(;hole*2<=currentSize;hole=child)
        {
            child=hole*2;

            if(child!=currentSize&&array[child+1].compareTo(array[child])<0)
                child++;
            if(array[child].compareTo(tmp)<0)
                array[hole]=array[child];
            else
                break;
        }
        array[hole]=tmp;
    }

    private static final int DEFAULT_CAPACITY=10;

    private int currentSize;

    private T[] array;

    private void buildHeap()
    {
        for(int i=currentSize/2;i>0;i--)
            percolateDown(i);
    }

    private void enlargeArray(int newSize)
    {

    }

}
