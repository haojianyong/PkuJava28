package debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
//2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子；
//3)直到P为NULL并且栈为空则遍历结束
public class solution94 {//中序遍历的非递归算法，出栈访问
	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode t=root;
	        while(t!=null || !stack.isEmpty()){
		        while (t != null) {
					stack.push(t);
					t = t.left;
				}
		        if(!stack.isEmpty()){
			        t = stack.pop();
			        list.add(t.val);
			        
			        t=t.right;
		        }	
	        }
	        return list;
	    }
}
