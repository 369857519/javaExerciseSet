package Tree;

/**
 * Created by qilianshan on 17/12/7.
 */
public class MergeTwoBinaryTrees {
    public void main(String[] args){

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null)return null;
        int val=0;
        if(t1!=null&&t2==null){
            val=t1.val;
            t2=new TreeNode(0);
        }
        if(t1==null&&t2!=null){
            val=t2.val;
            t2=new TreeNode(0);
        }
        if(t1!=null&&t2!=null)val=t1.val+t2.val;
        TreeNode newNode=new TreeNode(val);
        newNode.left=mergeTrees(t1.left,t2.left);
        newNode.right=mergeTrees(t1.right,t2.right);
        return newNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
