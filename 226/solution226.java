package debug;

public class solution226 {
	public TreeNode invertTree(TreeNode root) {
        if (root==null) {
			return null;
		}
        if(root.left!=null) {
			invertTree(root.left);
		}
        if (root.right!=null) {
			invertTree(root.right);
		}
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
        
    }
}
