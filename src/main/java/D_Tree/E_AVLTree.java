package D_Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by 祁连山 on 2017/9/23.
 */
public class E_AVLTree<T> implements Iterable<T> {
    private int height(AvlNode<T> t)
    {
        return t==null?-1:t.height;
    }

    private AvlNode root;
    
    private Comparator<? super T> comp;
    
    private int compare(T l,T r)
    {
        if(comp!=null)
            return comp.compare(l,r);
        else
            return ((Comparable)l).compareTo(r);
    }
    
    public Boolean insert(T x)
    {
        root=insert(x,root);
        return true;
    }
    
    private AvlNode<T> insert(T x,AvlNode<T> t)
    {
        if(t==null)
            return new AvlNode<T>(x,null,null);

        int compareResult=compare(x,t.element);

        if(compareResult<0)
        {
            t.left=insert(x,t.left);
            if(height(t.left)-height(t.right)==2)
                if(compare(x,t.left.element)<0)
                    t=rotateWithLeftChild(t);
                else
                    t=doubleWithLeftChild(t);
        }
        else if(compareResult>0)
        {
            t.right=insert(x,t.right);
            if(height(t.right)-height(t.left)==2)
                if(compare(x,t.right.element)>0)
                    t=rotateWithRightChild(t);
                else
                    t=doubleWithRightChild(t);
        }
        else
            ;
        t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2)
    {
        AvlNode<T> k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2)
    {
        AvlNode<T> k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.right),k2.height)+1;
        return k1;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3)
    {
        k3.left=rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3)
    {
        k3.right=rotateWithLeftChild((k3.right));
        return rotateWithRightChild(k3);
    }

    public Iterator<T> iterator() {
        return new B_Iterator<T>();
    }

    public String printTree()
    {
        Iterator<T> it=this.iterator();
        String str="";
        while (it.hasNext())
        {
            str=str+it.next()+' ';
        }
        return str;
    }

    private class B_Iterator<T> implements Iterator<T>
    {
        AvlNode<T> currentNode;
        private Stack<AvlNode<T>> s=new Stack<AvlNode<T>>();

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
            AvlNode<T> n=s.pop();
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
    
    private static class AvlNode<T>
    {
        AvlNode(T theElement)
        {this(theElement,null,null);}

        AvlNode(T theElement,AvlNode<T> lt,AvlNode<T> rt)
        {
            element=theElement;left=lt;right=rt;height=0;
        }
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }
}
