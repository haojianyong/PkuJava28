/**
 * Created by ASUS on 2016/1/11.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null&&root.right==null)
            return true;
        return isSy(root.left,root.right);
    }
    public boolean isSy(TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left.val != right.val) return false;
        return isSy(left.left, right.right) && isSy(left.right, right.left);
    }
}
