import java.util.HashSet;
import java.util.Set;

/**
 * Created by ASUS on 2016/1/8.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<=1)
            return false;
        Set<Integer> nums_set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            nums_set.add(nums[i]);
        }
        if(nums_set.size()<nums.length)
            return true;
        else return false;
    }
}
