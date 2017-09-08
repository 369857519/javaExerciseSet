package D_Tree;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by qilianshan on 17/9/7.
 */
public class B_TreeSet<T> extends AbstractSet {
    private BinaryNode root;

    private Comparator<? super T> cmp;

    public B_TreeSet()
    {
        this(null);
    }

    //可以声明一个泛型comparator，其中comparator中的类型是T的超类
    public B_TreeSet(Comparator<? super T> c)
    {
        root=null;cmp=c;
    }

    private int myCompare(T lhs,T rhs)
    {
        if(cmp!=null)
            return cmp.compare(lhs,rhs);
        else
            return ((Comparable)lhs).compareTo(rhs);
    }

    public void insert(T Element)
    {
        insert(Element,root,null);
    }

    private BinaryNode<T> insert(T Element,BinaryNode<T> node,BinaryNode<T> parent)
    {
        BinaryNode<T> t=node;
        if(t==null){
            t=new BinaryNode<T>(Element,null,null,parent);
        }
        if(myCompare(Element,node.element)==1){
            //大于的话在右子树插入
            node.right=insert(Element,node.right,node);
        }else if(myCompare(Element,node.element)==-1){
            //小于的话在左子树插入
            node.left=insert(Element,node.left,node);
        }
        return t;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private static class BinaryNode<T>
    {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
        BinaryNode<T> parent;
        BinaryNode(T Element)
        {
            this(Element,null,null,null);
        }
        BinaryNode(T Element,BinaryNode<T> lt,BinaryNode<T> rt,BinaryNode<T> pt)
        {
            element=Element;
            left=lt;
            right=rt;
            parent=pt;
        }
    }

}
