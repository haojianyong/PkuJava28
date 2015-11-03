import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ASUS on 2015/10/31.
 */
//用栈来实现二叉树的中序遍历
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        if(root==null){
            System.out.println("空树");
        }
        while (root!=null || !stack.empty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }
}
