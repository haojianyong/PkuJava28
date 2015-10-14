public class Solution {
    public int maxDepth(TreeNode root) {
        int l,r;
        if(root==null)return 0;
        l=maxDepth(root.left);
        r=maxDepth(root.right);
        int res=l<r?r+1:l+1;
        return res;
    }
}
