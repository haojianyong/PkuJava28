import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2015/10/3.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(rowIndex+1==1){
            list.add(1);
            return list;
        }
        if (rowIndex+1==2){
            list.add(1);
            list.add(1);
            return list;
        }
        else{
            list.add(1);
            result.add(list);
            list.add(1);
            result.add(list);
            for (int i=3;i<=rowIndex+1;i++){
                List<Integer> newlist=new ArrayList<Integer>();
                newlist.add(1);
                List<Integer> temlist=result.get(i-2);
                for(int j=1;j<i-1;j++) {
                    newlist.add(temlist.get(j)+temlist.get(j-1));
                }
                newlist.add(1);
                result.add(newlist);
            }
        }
        return result.get(rowIndex);
    }
    public static void main(String[] args){
        Solution s=new Solution();
        List<Integer> l=s.getRow(3);
        for (int i=0;i<l.size();i++)
            System.out.println(l.get(i));
    }
}
