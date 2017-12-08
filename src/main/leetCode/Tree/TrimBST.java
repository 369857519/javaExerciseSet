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
        int[] arr=new int[]{3,0,4,2,2};
        TreeNode root=ExampleSet.generateTree(arr);
        root=trimBST(root,1,2);
        ExampleSet.printTree(root);
    }
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)return null;
        if(root.val<L)return trimBST(root.right,L,R);
        if(root.val>R)return trimBST(root.left,L,R);
        //在遍历左子树之前对左子树进行判断
        if(root.val>=L&&root.val<=R){
            //这种情况下减掉左子树小的部分
            root.left=trimBST(root.left,L,R);
            //减掉右子树
            root.right=trimBST(root.right,L,R);
        }
        return root;
    }
}
