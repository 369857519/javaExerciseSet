package C_ADT;

/**
 * Created by qilianshan on 17/8/30.
 */
public class H_SelfAdjust<T> {
    private Node<T> beginMarker;
    private int modeCount=0;
    private int thisSize;

    public H_SelfAdjust(){
        clear();
    }

    private void clear(){
        beginMarker=new Node<T>(null,null,null);
        thisSize=0;
        modeCount++;
    }
    //find
    public boolean find(T t){
        Node<T> current=beginMarker.next;
        while (current!=null&&current.data!=t){
            current=current.next;
        }
        if(current!=null){
            current.prev.next=current.next;
            current.next.prev=current.prev;
            current.next=beginMarker.next;
            current.prev=null;
            beginMarker.next.prev=current;
            beginMarker.next=current;
            current.prev=beginMarker;
        }
        return true;
    }

    //add
    public boolean add(T t){
        beginMarker.data=t;
        Node<T> newBegin=new Node<T>(null,null,beginMarker);
        beginMarker.prev=newBegin;
        beginMarker=newBegin;
        this.thisSize++;
        modeCount++;
        return true;
    }

    public String toString()
    {
        String str="";
        Node<T> current=beginMarker.next;
        while (current!=null){
            str=str+current.data+',';
            current=current.next;
        }
        str=str.substring(0,str.length()-1);
        return str;
    }

    private class Node<T>
    {
        public Node<T> prev;
        public Node<T> next;
        public T data;
        public Node(T d,Node<T> p,Node<T> n)
        {
            data=d;
            prev=p;
            next=n;
        }
    }

}
