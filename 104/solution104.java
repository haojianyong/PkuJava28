package debug;
/**
 * Maximum Depth of Binary Tree
 */
public class solution104 {//1⃣️层次遍历可以求树深度，层次遍历需要定义队列2⃣️递归算法，max(左、右子树的深度)+1
	public class TreeNode {//树节点
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { //构造函数
	    	 val = x; 
	    }
	  }
	public static void main(String[] args) {
		

	}
	 public int maxDepth(TreeNode root) {
		 
		 int depth = 0;
		 int ldepth = 0;
		 int rdepth = 0;
//		 if (root.left.val!= 0){不能通过val值为0，判断左孩子在不在
//			ldepth = maxDepth(root.left);//左孩子存在
//		 }
		 if (root != null) {
			 if (root.left != null) {
				 ldepth = maxDepth(root.left);//左孩子存在
			}
//			 else {
//				ldepth = 0;
//			}
			 if (root.right != null){
				rdepth = maxDepth(root.right);//左孩子存在
			 }
//			 else {
//				rdepth = 0;
//			}
			 depth =(rdepth>=ldepth ? rdepth:ldepth)+1;

		}
//		 else {
//			depth = 0;
//		}
		return depth;
	     
	  }
}

