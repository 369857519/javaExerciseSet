package D_Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by qilianshan on 17/9/28.
 */
public class F_SplayTree<T> implements Iterable<T> {

    private Comparator<? super T> cmp;

    private BinaryNode<T> root;

    private int size;

    private int myCompare(T lhs,T rhs)
    {
        if(cmp!=null)
            //在这里可以看到comparator的使用，由于使用的是cmp，cmp一定会约束传入值是comparator中?的子类，
            //所以构造函数在接受comparator时，要求comparator内必须是super于T的
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

    private BinaryNode<T> findMax(BinaryNode<T> t){
        if(t!=null)
            if(t.deleted){
                if(t.right!=null){
                    t=findMax(t.right);
                }else if(t.left!=null){
                    t=findMax(t.left);
                }
            }else {
                while (t.right != null) {
                    if (t.right.deleted) {
                        t = findMax(t.right);
                    } else {
                        t = t.right;
                    }
                }
            }
        return t;
    }

    public void remove(T t){

    }

    public Iterator iterator() {
        return new B_Iterator();
    }

    private class B_Iterator<T> implements Iterator<T>
    {
        BinaryNode currentNode;
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
            currentNode=n;
            if(n.right!=null)
            {
                n=n.right;
                while (n!=null){
                    if(!n.deleted){
                        s.push(n);
                    }
                    n=n.left;
                }
            }
            return res;
        }

        public void remove() {
//            F_SplayTree.this.remove(currentNode.element);
        }
    }

    private static class BinaryNode<T>
    {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
        BinaryNode<T> parent;
        Boolean deleted=false;
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
            //最大
            BinaryNode p=this;
            while(p!=null){
                p=p.parent;
            }
            while (p!=null){
                p=p.right;
            }
        }
    }
}
