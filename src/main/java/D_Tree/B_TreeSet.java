package D_Tree;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by qilianshan on 17/9/7.
 */
public class B_TreeSet<T> extends AbstractSet<T> {
    private BinaryNode root;

    private int size;

    private Comparator<? super T> cmp;

    public B_TreeSet()
    {
        this(null);
    }

    //可以声明一个泛型comparator，其中comparator中的类型是T的超类
    public B_TreeSet(Comparator<? super T> c)
    {
        root=null;cmp=c;size=0;
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
        if(root==null){
            root=new BinaryNode(Element,null,null,null);
            return;
        }
        insert(Element,root,null);
    }

    private BinaryNode<T> insert(T Element,BinaryNode<T> node,BinaryNode<T> parent)
    {
        BinaryNode<T> t=node;
        if(t==null){
            t=new BinaryNode<T>(Element,null,null,parent);
            size++;
        }else if(myCompare(Element,node.element)==1){
            //大于的话在右子树插入
            node.right=insert(Element,node.right,node);
        }else if(myCompare(Element,node.element)==-1){
            //小于的话在左子树插入
            node.left=insert(Element,node.left,node);
        }
        return t;
    }

    public void getNode(BinaryNode<T> node){
        getNode(node.left);
        //next()
            getNode(node.right);
    }

    @Override
    public Iterator iterator() {
        return new B_Iterator();
    }

    private class B_Iterator<T> implements Iterator<T>
    {
        BinaryNode<T> currentNode;
        private Stack<BinaryNode<T>> s=new Stack<BinaryNode<T>>();

        public B_Iterator(){
            currentNode=root;
            while(currentNode!=null){
                s.push(currentNode);
                currentNode=currentNode.left;
            }
        }
        public boolean hasNext() {
            return !s.empty();
        }

        public T next() {
            BinaryNode<T> n=s.pop();
            T res=n.element;
            if(n.right!=null)
            {
                n=n.right;
                while (n!=null){
                    s.push(n);
                    n=n.left;
                }
            }
            return res;
        }

        public void remove() {

        }
    }

    @Override
    public int size() {
        return size;
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
