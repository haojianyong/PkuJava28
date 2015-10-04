public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
    if(numRows<=0)return res;
    List<Integer> item=new ArrayList<Integer>();
    item.add(1);
    res.add(item);
    for(int i=2;i<=numRows;i++){
        List<Integer> last=res.get(res.size()-1);
        List<Integer> newItem=new ArrayList<Integer>();
        newItem.add(1);
        for(int j=0;j<last.size()-1;j++){
            newItem.add(last.get(j)+last.get(j+1));
        }
        newItem.add(1);
        res.add(newItem);
    }
    return res;
    }
}
