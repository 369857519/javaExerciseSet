package C_ADT;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by qilianshan on 17/8/14.
 */
public class C_Sets {

    public static void main(String[] args){
//        switchNode();
//        intersection();
        hotPotato(5,1);
    }

    public static void switchNode(){
        B_LinkedList<Integer> bllist=new B_LinkedList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        bllist.swap(2,3);
        System.out.println(bllist.size());
        for (int i:bllist)
        {
            System.out.println(i);
        }
        System.out.println(bllist.contains(11));
        System.out.println(bllist.contains(4));
    }

    public static void intersection(){
        ArrayList<Integer> ar1=new ArrayList<Integer>(){{
            add(1);add(4);add(5);add(7);add(9);
        }};
        ArrayList<Integer> ar2=new ArrayList<Integer>(){{
            add(2);add(4);add(6);add(8);add(10);
        }};
        ArrayList<Integer> interArr=new ArrayList<Integer>();
        for(int i:ar1){
            if(ar2.contains(i)){
                interArr.add(i);
            }
        }
        System.out.print(interArr);
        interArr.clear();

        for(int i:ar1){
            if(!ar2.contains(i)){
                interArr.add(i);
            }
        }
        interArr.addAll(ar2);
        System.out.print(interArr);
    }
    //时间复杂度为o(N)
    public static void hotPotato(int N,int M) {
        B_LinkedList<Integer> CirList=new B_LinkedList<Integer>();
        for(int i=1;i<=N;i++){
            CirList.add(i);
        }

        Iterator<Integer> ite=CirList.iterator();
        System.out.print(ite);

        int count=0;
        while (!CirList.isEmpty()){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            count++;
            ite.next();
            if(count==M+1){
                count=0;
                ite.remove();
            }
        }
    }

}
