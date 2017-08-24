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
//        hotPotato(5,1);
//        myArrayListTest();
//        D_SingleListTest();
          arrayListTest();
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
    //3.7
    //trimToSize的时候会重新分配一遍大小，耗时n
    //然后又进行一次add，需要重新分配大小，耗时n
    //一共是n*(n+n)=o(n^2)

    //3.8
    //a如果不记录，size会发生改变
    //b o(n^2)
    //c o(n^2)
    //d 使用迭代器只能使linkedList的removeFirstHalf变快

    public static void myArrayListTest()
    {
        final A_ArrayList<Integer> arr=new A_ArrayList<Integer>();
        //addAll的操作时间复杂度为o(n)
        arr.addAll(new ArrayList<Integer>(){{
            add(1);add(3);add(5);add(7);add(9);
        }});

        for(int i:arr)
        {
            System.out.print(i);
        }
        //总体复杂度是o(n^2)
        arr.removeAll(new ArrayList<Integer>(){{
            add(1);add(3);add(3);
        }});

        for(int i:arr)
        {
            System.out.print(i);
        }
    }

    private static void D_SingleListTest(){
        D_SingleList<Integer> singleList=new D_SingleList<Integer>(){{
            add(1);add(3);add(5);add(6);add(13);
        }};
        System.out.println(singleList);

        System.out.println(singleList.size());

        System.out.println(singleList.contains(3));

        singleList.addIfNotContains(10);
        singleList.addIfNotContains(13);

        System.out.println(singleList);

        singleList.removeIfContains(10);
        singleList.removeIfContains(13);

        System.out.println(singleList);
    }

    private static void arrayListTest(){
        E_SimpleLinkedList<Integer> arr=new E_SimpleLinkedList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println(arr);
        Iterator<Integer> itr= arr.iterator();
        itr.next();
        itr.remove();
        System.out.println(arr);

    }

    private static void lazyDelete(){
        //懒惰删除优点在于删除本身的操作复杂度降低，而且在数据较少时，可以进行数据恢复，但是遍历时复杂度增加
    }

}
