package D_Tree;

import java.util.*;

/**
 * Created by qilianshan on 17/9/13.
 */
public class C_TreeMap<K,V> implements Map<K,V>{

    private BinaryNode root;

    private int size;

    private Comparator<? super V> cmp;

    public C_TreeMap()
    {
        this(null);
    }

    public C_TreeMap(Comparator<? super V> c)
    {
        root=null;cmp=c;size=0;
    }

    private int myCompare(V lhs,V rhs)
    {
        if(cmp!=null)
            //在这里可以看到comparator的使用，由于使用的是cmp，cmp一定会约束传入值是comparator中?的子类，
            //所以构造函数在接受comparator时，要求comparator内必须是super于T的
            return cmp.compare(lhs,rhs);
        else
            return ((Comparable)lhs).compareTo(rhs);
    }

    public void insert(Entry<K,V> Element)
    {
        if(root==null){
            root=new BinaryNode(Element,null,null,null);
            return;
        }
        insert(Element,root,null);
    }

    private BinaryNode<Entry<K,V>> insert(Entry<K,V> Element,BinaryNode<Entry<K,V>> node,BinaryNode<Entry<K,V>> parent)
    {
        BinaryNode<Entry<K,V>> t=node;
        if(t==null){
            t=new BinaryNode<Entry<K, V>>(Element,null,null,parent);
            size++;
        }else if(myCompare(Element.getValue(),node.element.getValue())==1){
            node.right=insert(Element,node.right,node);
        }else if(myCompare(Element.getValue(),node.element.getValue())==-1){
            node.left=insert(Element,node.left,node);
        }
        return t;
    }



    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public V get(Object key) {
        return null;
    }

    public V put(K key, V value) {
        return null;
    }

    public V remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

    }

    public void clear() {

    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        return null;
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
