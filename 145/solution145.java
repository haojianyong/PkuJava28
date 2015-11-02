package debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class solution145 {//二叉树后序遍历
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        TreeNode prev = root;    
        while (t != null || !stack.isEmpty()) {    
            while (t != null) {    
                stack.push(t);    
                t = t.left;    
            }    
            if (!stack.isEmpty()) {    
            	TreeNode temp = stack.peek().right;    
                if (temp == null || temp == prev) {    
                    t = stack.pop();    
                    list.add(t.val);    
                    prev = t;    
                    t = null;    
                } else {    
                    t = temp;    
                } 
            }        
        }
        return list;
	}
}