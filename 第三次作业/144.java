public class Solution {
    public void helper(TreeNode root,List<Integer> res){
        if(root==null)return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        helper(root,res);
        return res;
    }
}
