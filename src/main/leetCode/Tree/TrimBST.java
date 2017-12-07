package Tree;

/**
 * Created by qilianshan on 17/12/7.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TrimBST {
    public static void main(String[] args){
        int[] arr=new int[]{0,1,2};
        TreeNode root=ExampleSet.generateTree(arr);
        root=trimBST(root,1,2);
        ExampleSet.printTree(root);
    }
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)return null;
        TreeNode returnValue=null;
        //在遍历左子树之前对左子树进行判断
        //在这里进行比较
        if(root.left!=null&&root.left.val<L&&root.val>=L){
            root.left=null;
        }
        trimBST(root.left,L,R);
        //判断自身的值和右子树值
        if(root.right!=null&&root.right.val>R&&root.val<=R){
            root=null;
        }
        trimBST(root.right,L,R);
        return root;
    }
}
