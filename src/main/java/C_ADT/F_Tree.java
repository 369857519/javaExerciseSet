package C_ADT;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by qilianshan on 17/8/28.
 */
public class F_Tree<T> implements Iterable {

    private Set<String> calSet=new TreeSet<String>(){{
        add("+");
        add("-");
        add("*");
        add("/");
        add("^");
    }};

    public static void main(String[] args)
    {
        F_Tree<String> tree=new F_Tree<String>();
        String[] str=new String[]{"A","B","C","+","*","D","/"};
        Stack<String> stk=new Stack<String>();
        for(int i=0;i<str.length;i++)
        {
            stk.push(str[i]);
        }
        System.out.println(tree.print(tree.generateTree(stk.pop(), stk)));
    }

    public static void buildTreeFromPostfix(String[] strArr)
    {
        Stack<String> stk=new Stack<String>();
        int i=0;
        while(strArr[i]!=null){
            stk.push(strArr[i]);
            i++;
        }
    }
    public Node<T> generateTree(T root,Stack<T> dataSource)
    {
        Node<T> rightNode=null;Node<T> leftNode=null;
        T right=dataSource.pop();
        if(calSet.contains(right)){
            rightNode=generateTree(right,dataSource);
        }else{
            rightNode=new Node<T>(right,null,null);
        }
        T left=dataSource.pop();
        if(calSet.contains(left)){
            leftNode=generateTree(left,dataSource);
        }else{
            leftNode=new Node<T>(left,null,null);
        }
        return new Node<T>(root,leftNode,rightNode);
    }

    //做一个中序遍历，并输出结果
    public String print(Node<T> root){
        if(root.leftChild==null&&root.rightChild==null){
            return root.data.toString();
        }
        //做一次优先级判断，看是否要添加括号
        return "("+print(root.leftChild)+root.data.toString()+print(root.rightChild)+")";
    }

    private class Node<T>{
        public Node<T> leftChild;
        public Node<T> rightChild;
        public T data;
        public Node(T d,Node<T> left,Node<T> right){
            leftChild=left;
            rightChild=right;
            data=d;
        }
    }

    public Iterator iterator() {
        return null;
    }


}
