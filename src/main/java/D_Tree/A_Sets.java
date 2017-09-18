package D_Tree;

import java.util.Iterator;

/**
 * Created by qilianshan on 17/9/7.
 */
public class A_Sets {
    //树的深度，高度，父节点，儿子，兄弟
    //4.4 n+1null链有n个节点
    //4.5 高度为h的二叉树，节点最大个数为2^(h+1)-1
    //4.6 满树的节点为2^(n-1)-1，叶子的个数为 2^(n-1).
    //4.7 二叉树有树叶l1,l2,...,lm，各树叶的深度分别是d1,d2,...,dm。
    //4.8 前缀 -**ab+cde
    //      中缀 (a*b)*(c+d)-c 后缀 ab*cd+*e-
    //4.9 remove算法：找到右子树最小节点替换，然后移除右子树的节点（递归）
    public static void main(String[] args)
    {
        B_TreeSet<Integer> treeSet=new B_TreeSet<Integer>(){{
            insert(3);
            insert(22);
            insert(5);
            insert(13);
            insert(14);
            insert(6);
            insert(8);
            insert(21);
            insert(10);
        }};

        System.out.println(treeSet.printTree());

        treeSet.remove(8);

        System.out.println(treeSet.printTree());



    }

}
