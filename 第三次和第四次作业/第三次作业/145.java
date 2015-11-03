import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ASUS on 2015/11/2.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null)
            return list;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while (root!=null || !stack.isEmpty()){
            if(!stack.isEmpty())
                root=stack.peek();
            if(root.left==null && root.right==null){
                if(!stack.isEmpty()) {
                    root=stack.pop();
                    list.add(root.val);
                }
                else
                    break;
            }
            else{
                if(root.right!=null){
                    stack.add(root.right);
                    root.right=null;
                }
                if(root.left!=null){
                    stack.add(root.left);
                    root.left=null;
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode3=new TreeNode(4);
        TreeNode treeNode4=new TreeNode(5);
        TreeNode treeNode5=new TreeNode(6);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.right=treeNode5;
        List<Integer> list=new ArrayList<Integer>();
        list=solution.postorderTraversal(treeNode);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
