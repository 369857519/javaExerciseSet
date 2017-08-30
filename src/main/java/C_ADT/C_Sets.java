package C_ADT;

import javax.swing.text.StyledEditorKit;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by qilianshan on 17/8/14.
 */
public class C_Sets {

    public static void main(String[] args){
//      switchNode();
//      intersection();
//      hotPotato(5,1);
//      myArrayListTest();
//      D_SingleListTest();
//      arrayListTest();
//        System.out.println(testLegalSquence("()()("));
//        System.out.println(testLegalSquence("{}(({{}}))"));
//        System.out.println(calSufixExpression(new String[]{"3","4","+","5","*","6","-"}));
//        System.out.println(calSufixExpression(infixToSufix(new String[]{"(","3","^","2","+","4",")","*","5","-","6"})));
        H_SelfAdjust<Integer> self=new H_SelfAdjust<Integer>(){{
            add(1);add(2);add(3);add(4);
        }};

        self.find(3);

        System.out.println(self);
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

    public static boolean testLegalSquence(String str){
        Stack<Character> stk=new Stack<Character>();
        Map<Character,Character> map=new HashMap<Character, Character>(){{
            put('}','{');put(']','[');put(')','(');
        }};
        stk.push(str.charAt(0));
        for(int i=1;i<str.length();i++)
        {
            if(stk.size()!=0&&map.get(str.charAt(i))==stk.lastElement()){
                stk.pop();
            }else{
                stk.push(str.charAt(i));
            }
        }
        return stk.size()==0;
    }

    public static int calSufixExpression(String[] str){
        int result=0;
        Set<String> set=new TreeSet<String>(){{
            add("+");
            add("-");
            add("*");
            add("/");
            add("^");
        }};
        Stack<String> stk=new Stack<String>();
        int temp=0;
        for(int i=0;str[i]!=null;i++){
            if(set.contains(str[i])&&str[i].length()==1){
                switch (str[i].charAt(0)){
                    case '+':
                        result=Integer.parseInt(stk.pop())+Integer.parseInt(stk.pop());
                        stk.push(String.valueOf(result));
                        break;
                    case '-':
                        temp=Integer.parseInt(stk.pop());
                        result=Integer.parseInt(stk.pop())-temp;
                        stk.push(String.valueOf(result));
                        break;
                    case '*':
                        result=Integer.parseInt(stk.pop())*Integer.parseInt(stk.pop());
                        stk.push(String.valueOf(result));
                        break;
                    case '/':
                        temp=Integer.parseInt(stk.pop());
                        result=Integer.parseInt(stk.pop())/temp;
                        stk.push(String.valueOf(result));
                        break;
                    case '^':
                        temp=Integer.parseInt(stk.pop());
                        result=(int)Math.pow(Integer.parseInt(stk.pop()),temp);
                        stk.push(String.valueOf(result));
                        break;
                    default:
                        break;
                }
            }else{
                stk.push(str[i]);
            }
        }
        return result;
    }

    public static String[] infixToSufix (String[] str){
        String[] result=new String[100];
        //使用优先级队列来存储优先级
        Map<String,Integer> prior=new HashMap<String, Integer>(){{
           put("^",3);put("*",2);put("/",2);put("+",1);put("-",1);
        }};
        Stack<String> resultStk=new Stack<String>();
        Stack<String> symbolStk=new Stack<String>();
        for(String i:str){
            if(i=="("){
                symbolStk.push(i);
            }else if(i==")"){
                String temp=symbolStk.pop();
                while(temp!="("&&temp!=null){
                    resultStk.push(temp);
                    temp=symbolStk.pop();
                }
            }else if(prior.get(i)==null){
                //如果是数字
                resultStk.push(i);
            }else{
                //如果是符号
                //比较优先级
                while(symbolStk.size()!=0
                        &&symbolStk.lastElement()!="("
                        &&prior.get(i)<=prior.get(symbolStk.lastElement())){
                        resultStk.push(symbolStk.pop());
                }
                symbolStk.push(i);
            }
        }
        while (symbolStk.size()!=0){
            resultStk.push(symbolStk.pop());
        }
        return resultStk.toArray(result);
    }

}
