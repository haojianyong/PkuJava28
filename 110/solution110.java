package debug;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class solution110 {//判断是否为平衡二叉树
	public boolean isBalanced(TreeNode root) {
        if (root==null) {
			return true;
		}
		int a = depth(root.left);
        int b = depth(root.right);
        if (Math.abs(a-b)<=1&& isBalanced(root.left)&& isBalanced(root.right)) {
			return true;
		}
        return false;
    }
	private int depth(TreeNode root) {
		int depth=0;
		if (root==null) {
			return depth;
		}
		else {
			return Math.max(depth(root.left), depth(root.right))+1;
		}
	}
}
