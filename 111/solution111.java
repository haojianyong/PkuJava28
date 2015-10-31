package debug;

 
public class solution111 {
	public int minDepth(TreeNode root) {//
	      
			 int depth = 0;
			 int ldepth = 0;
			 int rdepth = 0;
			 if (root != null) {//根节点要额外判断一下
				 if(root.left==null) {
					 depth=minDepth(root.right)+1;
					 return depth;
					 }
				 if(root.right==null) {
					 depth=minDepth(root.left)+1;
					 return depth;}
				 if (root.left != null) {
					 ldepth = minDepth(root.left);//左孩子存在
				}
				 if (root.right != null){
					rdepth = minDepth(root.right);//右孩子存在
				 }
				 depth =(rdepth>=ldepth ? ldepth:rdepth)+1;

			}
			return depth;
	    }
	
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}