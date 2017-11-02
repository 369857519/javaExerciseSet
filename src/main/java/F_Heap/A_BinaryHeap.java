package F_Heap;

import java.nio.BufferUnderflowException;

/**
 * Created by qilianshan on 17/10/31.
 */
public class A_BinaryHeap<T extends Comparable<? super T>> {

    public static void main(String[] args)
    {
        A_BinaryHeap<Integer> heap=new A_BinaryHeap();
        heap.insert(10);
        heap.insert(12);
        heap.insert(1);
        heap.insert(14);
        heap.insert(6);
        heap.insert(5);
        heap.insert(8);
        heap.insert(15);
        heap.insert(3);
        heap.insert(9);
        heap.insert(7);
        heap.insert(4);
        heap.insert(11);
        heap.insert(13);
        heap.insert(2);
        System.out.println(heap.toString());
    }

    public A_BinaryHeap(){
        currentSize=0;
        array=(T[])new Comparable[(currentSize+2)*11/10];
    }

    public A_BinaryHeap(int capacity)
    {
        currentSize=capacity;
        array=(T[])new Comparable[(currentSize+2)*11/10];
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
        //数组为空的情况下，直接插入
//        while (hole>1&&array[hole]==null){
//            hole/=2;
//        }
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
        T[] newArr=(T[]) new Comparable[newSize];
        int i=0;
        for(T item:array){
            newArr[i++]=item;
        }
        array=newArr;
    }

    public String toString(){
        String str="";
        for(int i=1;i<=currentSize;i++)
        {
            str+=array[i].toString();
            str+=",";
        }
        str=str.substring(0,str.length()-1);
        return str;
    }

}
