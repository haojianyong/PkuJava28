import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ASUS on 2015/11/1.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return null;
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                list.add(root.val);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        return list;
    }
}
