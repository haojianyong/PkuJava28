/**
 * Created by ASUS on 2015/10/1.
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> L=new ArrayList<Integer>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if (numRows==0)
            return result;
        if(numRows==1){
            //L.add(0,1);
            L.add(1);
            //result.add(0,L);
            result.add(L);
            return result;
        }
        if (numRows==2){
            result=generate(1);
            L.add(1);
            L.add(1);
            result.add(L);
            return result;
        }
        else{
            result=generate(2);
            for(int i=3;i<=numRows;i++){
                //L=null;
                //L.add(0,1);
                //L.add(i-1,1);
                List<Integer> temList=result.get(i-2);
                List<Integer> newList=new ArrayList<Integer>();
                newList.add(1);
                for (int j=1;j<i-1;j++){
                    newList.add(j, temList.get(j)+temList.get(j-1));
                }
                newList.add(1);
                result.add(i-1,newList);
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        List<List<Integer>> L= s.generate(5);
        //System.out.println(L.size()+"mksajdia");
        for (int i=0;i<L.size();i++)
            for (int j=0;j<L.get(i).size();j++)
                System.out.println(L.get(i).get(j));
    }

}