/**
 * Created by ASUS on 2015/10/11.
 */

 // Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  };
public class Solution {
    int max(int a,int b){
        return a>b?a:b;
    }
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int LeftDepth=maxDepth(root.left);
        int RightDepth=maxDepth(root.right);
        return max(LeftDepth,RightDepth)+1;
    }
}
