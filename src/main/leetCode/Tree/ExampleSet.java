package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by qilianshan on 17/12/7.
 */
public class ExampleSet {
    public static TreeNode generateTree(int[] arr)
    {
        TreeNode tn=null;
        for(int i=0;i<arr.length/2;i++){
            TreeNode tnTmp=new TreeNode(arr[i]);
            if(i==0)tn=tnTmp;
            tnTmp.left=new TreeNode(arr[i*2+1]);
            tnTmp.right=new TreeNode(arr[i*2+2]);
        }
        return tn;
    }
    public static void printTree(TreeNode tn)
    {
        Queue<TreeNode> queue=new ArrayDeque<TreeNode>();
        TreeNode tmp=tn;
        queue.add(tn);
        while(!queue.isEmpty())
        {
            tmp=queue.remove();
            System.out.println(tmp.val);
            if(tmp.left!=null)queue.add(tmp.left);
            if(tmp.right!=null)queue.add(tmp.right);
        }
    }
}
