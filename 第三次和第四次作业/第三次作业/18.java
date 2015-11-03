import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ASUS on 2015/10/29.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
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
                        end--;start++;
                    }
                    else if(nums[i]+nums[j]+nums[start]+nums[end]>target)
                        end--;
                    else
                        start++;
                }
            }
        }
        HashSet<List<Integer>> h = new HashSet<List<Integer>>(lists);
        lists.clear();
        lists.addAll(h);
        return lists;
    }
    public static void main(String[] args){
        int[] nums={-3,-2,-1,0,0,1,2,3};
        Solution s=new Solution();
        List<List<Integer>> lists=s.fourSum(nums,0);
        for(int i=0;i<lists.size();i++)
        {
            for (int j=0;j< lists.get(i).size();j++)
            {
                System.out.print((int) lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    /*public List<List<Integer>> threeSum(int[] nums,int target){
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                List<List<Integer>> tempList=new ArrayList<List<Integer>>();
                tempList=twoSum(nums,target-nums[i]);
            }
        }
    }
    public List<List<Integer>> twoSum(int[] nums,int target){
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                List<Integer> list=new ArrayList<Integer>();
                if(nums[j]==target-nums[i]){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }*/
}
