public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        int l=0,r=0;
        l=minDepth(root.left);
        r=minDepth(root.right);
        if(l==0)return r+1;
        if(r==0)return l+1;
        if(l<r)return l+1;
        else return r+1;
    }
}
