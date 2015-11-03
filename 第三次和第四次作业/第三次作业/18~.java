import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ASUS on 2015/10/31.
 */
public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for (int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int start=j+1;
                int end=nums.length-1;
                while (start<end){
                    if(nums[i]+nums[j]+nums[start]+nums[end]==target){
                        List<Integer> list=new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        lists.add(list);
                        while (start>j+1 && start<nums.length-3 && nums[start+1]==nums[start])
                            start++;
                        while (start<end && end<nums.length && nums[end-1]==nums[end])
                            end--;
                        end--;start++;
                    }
                    else if(nums[i]+nums[j]+nums[start]+nums[end]>target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return lists;
    }
    public static void main(String[] args){
        int[] nums={-5,-5,-3,-1,0,2,4,5};
        Solution2 s=new Solution2();
        List<List<Integer>> lists=s.fourSum(nums,-7);
        for(int i=0;i<lists.size();i++)
        {
            for (int j=0;j< lists.get(i).size();j++)
            {
                System.out.print((int) lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
