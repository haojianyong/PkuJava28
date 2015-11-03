import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ASUS on 2015/10/30.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            if(nums[i]>0)
                break;
            /*if(i!=0 && nums[i+1]==nums[i])
                continue;*/
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            int start=i+1,end=nums.length-1;
            while (start<end){
                /*if (start<end && nums[start]==nums[start+1]){
                    start++;continue;
                }
                if(start<end && nums[end]==nums[end-1]){
                    end--;continue;
                }*/
                if(nums[i]+nums[start]+nums[end]==0){
                    List<Integer> list =new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    lists.add(list);
                    while (start<nums.length-2 && nums[start+1]==nums[start]){
                        start++;
                    }
                    while(end<nums.length-1 && nums[end-1]==nums[end]) {
                        end--;
                    }
                    start++;
                    end--;
                }
                else if(nums[i]+nums[start]+nums[end]<0)
                    start++;
                else if(nums[i]+nums[start]+nums[end]>0)
                    end--;
            }
        }
        /*HashSet<List<Integer>> hashSet=new HashSet<List<Integer>>(lists);
        lists.clear();
        lists.addAll(hashSet);*/
        return lists;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        //int[] nums={-1,0,1,2,-1,-4};
        int[] nums={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        int[] nums1={5,-11,-7,-2,4,9,4,4,-5,12,12,-14,-5,3,-3,-2,-6,3,3,-9,4,-13,6,2,11,12,10,-14,-15,11,0,5,8,0,10,-11,-6,-1,0,4,-4,-3,5,-2,-15,9,11,-13,-2,-8,-7,9,-6,7,-11,12,4,14,6,-4,3,-9,-14,-12,-2,3,-8,7,-13,7,-12,-9,11,0,4,12,-6,-7,14,-1,0,14,-6,1,6,-2,-9,-4,-11,12,-1,-1,10,-7,-6,-7,11,1,-15,6,-15,-12,12,12,3,1,9,12,9,0,-11,-14,-1};
        int[] nums2={-2,0,0,2,2};
        List<List<Integer>> lists=solution.threeSum(nums2);
        System.out.println("size:"+lists.size());
        for(int i=0;i<lists.size();i++)
        {
            for (int j=0;j< 3;j++)
            {
                System.out.print((int) lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
