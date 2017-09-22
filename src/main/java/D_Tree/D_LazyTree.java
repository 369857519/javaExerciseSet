package D_Tree;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by qilianshan on 17/9/7.
 */
public class D_LazyTree<T> extends AbstractSet<T> {
    private BinaryNode root;

    private int size;

    private Comparator<? super T> cmp;

    public D_LazyTree()
    {
        this(null);
    }

    //可以声明一个泛型comparator，其中comparator中的类型是T的超类

    public D_LazyTree(Comparator<? super T> c)
    {
        root=null;cmp=c;size=0;
    }

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

    public boolean remove(Object Element)
    {
        if(root==null)
        {
            throw new NoSuchElementException();
        }
        root=removeM((T) Element, root);
        return true;
    }

    private BinaryNode<T> removeM(T x,BinaryNode<T> t)
    {
        if(t==null)
            return t;
        int compareResult=myCompare(x, t.element);

        if(compareResult<0)
            t.left=removeM(x, t.left);
        else if(compareResult>0)
            t.right=removeM(x, t.right);
        else{
            //如果左右子树都不为零，在右子树中找到最小的节点替换上来，然后将右子树的对应节点删除
            t.deleted=true;
        }
        return t;
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

    private BinaryNode<T> getNode(T Element,BinaryNode<T> root)
    {

        if(root.element==Element){
            return root;
        }else{
            root=null;
            BinaryNode<T> left=getNode(Element,root.left);
            if(left!=null){
                root=left;
            }
            BinaryNode<T> right=getNode(Element,root.right);
            if(right!=null){
                root=right;
            }
        }
        return root;
    }

    public T findMin()
    {
        return findMin(root).element;
    }

    private BinaryNode<T> findMin(BinaryNode<T> t){
        if(t!=null)
            if(t.deleted){
                if(t.left!=null){
                    t=findMin(t.left);
                }else if(t.right!=null){
                    t=findMin(t.right);
                }
            }else{
                while (t.left!=null){
                    if(t.left.deleted){
                        t=findMin(t.left);
                    }else{
                        t=t.left;
                    }
                }

            }
        return t;
    }

    public T findMax(){
        return findMax(root).element;
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
            D_LazyTree.this.remove(currentNode.element);
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
