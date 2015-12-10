public class Solution {
    public boolean find(TreeNode root,TreeNode p,ArrayList<TreeNode> s){
        boolean status=false;
        if(root!=null){
            s.add(root);
            if(root==p){status=true;return status;}
            status=find(root.left,p,s);
            if(status)return status;
            status=find(root.right,p,s);
            if(status)return status;
            else{
                s.remove(s.size()-1);
            }
        }
        return status;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pp=new ArrayList<TreeNode>();
        ArrayList<TreeNode> qq=new ArrayList<TreeNode>();
        find(root,p,pp);
        find(root,q,qq);
        int i=0;
        while(i<pp.size()&&i<qq.size()){
            if(i+1>=pp.size())return pp.get(i);
            if(i+1>=qq.size())return qq.get(i);
            if(pp.get(i+1)!=qq.get(i+1))return pp.get(i);
            i++;
        }
        System.out.println(pp);
        System.out.println(qq);
        return root;
    }
}
