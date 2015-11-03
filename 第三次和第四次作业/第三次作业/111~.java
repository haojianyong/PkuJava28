import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2015/11/1.
 */
public class Solution2 {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        List<TreeNode> list=new ArrayList<TreeNode>();
        list.add(root);
        int count=1;
        while (!list.isEmpty()){
            List<TreeNode> temp_list=new ArrayList<TreeNode>();
            for (TreeNode treeNode:list){
                if(treeNode.left==null && treeNode.right==null)
                    return count;
                if(treeNode.left!=null)  temp_list.add(treeNode.left);
                if(treeNode.right!=null) temp_list.add(treeNode.right);
            }
            count++;
            list=new ArrayList<TreeNode>(temp_list);
        }
        return count;
    }
}
