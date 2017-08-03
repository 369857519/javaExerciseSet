package B_Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by qilianshan on 17/7/28.
 */
public class RandomSubstitution {
    public static void main(String[] args){
        RandomSubstitution rd=new RandomSubstitution();
        ArrayList<Integer> arr=new ArrayList<Integer>();

        //1000000 xx 3e9 2e8
        //100000 7e10 2e8 2e7
        //10000 4e8 5e7 7e6
        //1000 7e7 8e6 1e6
        //100 6e6 1e6 2e5
        int count=1089000;
        long startTime;
        long stopTime;
        startTime=System.nanoTime();
//        rd.randSwitch(arr,count);
        stopTime=System.nanoTime();
        System.out.printf("1,%d\n",stopTime-startTime);

        startTime=System.nanoTime();
//        rd.randSwitchWithHash(arr,count);
        stopTime=System.nanoTime();
        System.out.printf("2,%d\n",stopTime-startTime);

        startTime=System.nanoTime();
//        rd.randSwitchWithReference(arr,count);
        stopTime=System.nanoTime();
        System.out.printf("3,%d\n", stopTime - startTime);

        startTime=System.nanoTime();
        int c=count*(count/2);
        stopTime=System.nanoTime();
        System.out.printf("*,%d\n",stopTime-startTime);

        startTime=System.nanoTime();
        c=count/(3271908/2);
        stopTime=System.nanoTime();
        System.out.printf("/,%d\n",stopTime-startTime);

        startTime=System.nanoTime();
        c=count+(count/2);
        stopTime=System.nanoTime();
        System.out.printf("+,%d\n",stopTime-startTime);
    }
    public static int randInt(int i,int j){
        return (int)(Math.random()*(j-i)+i);
    }

    //直接用随机数插入 o(n^2)
    public ArrayList<Integer> randSwitch(ArrayList<Integer> arr,int n){
        while(arr.size()<n){
            int i=randInt(0,n);
            if(!arr.contains(i)){
                arr.add(i);
            }
        }
//        System.out.println(arr);
        return arr;
    }

    //增加哈希表的使用 o(n)
    public ArrayList<Integer> randSwitchWithHash(ArrayList<Integer> arr,int n){
        arr.clear();
        HashSet<Integer> hash=new HashSet<Integer>();
        while(arr.size()<n){
            int i=randInt(0,n);
            if(!hash.contains(i)){
                arr.add(i);
                hash.add(i);
            }
        }
//        System.out.println(arr);
        return arr;
    }

    //置换 o(n)
    public ArrayList<Integer> randSwitchWithReference(ArrayList<Integer> arr,int n){
        arr.clear();
        for(int i=0;i<n ;i++){
            arr.add(i);
        }
        for(int i=0;i<n;i++){
            int rand=randInt(0,n);
            int temp=arr.get(rand);
            arr.set(rand,arr.get(i));
            arr.set(i,temp);
        }
//        System.out.println(arr);
        return arr;
    }
}
