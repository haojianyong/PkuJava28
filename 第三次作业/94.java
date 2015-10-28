public class Solution {
    public void helper(TreeNode root,List<Integer> res){
        if(root==null)return;
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        helper(root,res);
        return res;
    }
}
