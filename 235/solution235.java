package debug;
//平衡二叉树中，两个节点的最近祖先
//相对于根节点，一左一右,返回root：eg.2，8
//根节点之左(两者之大比根小)，root改为左孩子，LCA(6.0.5)-->LCA(2,0,5)
//根节点之右(两者之小比根大)
//      _______6______
//     /              \
//  ___2__          ___8__
// /      \        /      \
// 0      _4       7       9
//       /  \
//      3   5
public class solution235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||p==null||q==null) {
			return null;
		}
        if (Math.max(p.val, q.val)<root.val) {
			return lowestCommonAncestor(root.left, p, q);//根节点之左
		}
        else if (Math.min(p.val, q.val)>root.val) {
        	return lowestCommonAncestor(root.right, p, q);//根节点之右
		}
        else{
        	return root;
        }
        
    }

}
