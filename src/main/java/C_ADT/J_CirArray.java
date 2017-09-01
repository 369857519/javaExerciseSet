package C_ADT;

import java.util.NoSuchElementException;

/**
 * Created by qilianshan on 17/8/31.
 */
public class J_CirArray<T> {
    private static final int DEFAULT_CAPACITY=3;
    private int theSize;
    private T[] theItems;
    private int modCount=0;
    private int start=0;
    private int end=0;

    public J_CirArray()
    {
        start=end=0;
        theSize=0;
        modCount++;
        theItems=(T[])new Object[DEFAULT_CAPACITY];
    }

    private boolean isLegall(){
        if(theSize>theItems.length){
            return false;
        }
        if(start<end){
            return end-start==theSize;
        }else if(start>end){
            return theItems.length-start+end==theSize;
        }else{
            if(theSize==0){
                return true;
            }else{
                return theSize==theItems.length;
            }
        }
    }

    public String toString()
    {
        String str="";
        for(int j=start,i=0;i<theSize;i++,j++){
            if(j==theItems.length){
                j=0;
            }
            str=str+theItems[j]+",";
        }
        str=str.substring(0,str.length()-1);
        return str;
    }

    public boolean enqueue(T t){
        end++;
        theSize++;
        if(!isLegall()){
            throw new IndexOutOfBoundsException();
        }
        if(end==theItems.length){
            end=0;
            //判断合法性
            theItems[theItems.length-1]=t;
        }else{
            theItems[end-1]=t;
        }

        modCount++;
        return true;
    }

    public T dequeue(){
        start++;
        theSize--;
        T data;
        if(start==theItems.length){
            start=0;
            data=theItems[theItems.length-1];
            theItems[theItems.length-1]=null;
        }else{
            data=theItems[start-1];
            theItems[start-1]=null;
        }
        modCount++;
        return data;
    }
}
