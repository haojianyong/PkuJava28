/**
 * Created by ASUS on 2015/11/24.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        int new_length=0;
        for(int i=0;i<nums.length;i++){
            if(nums[new_length]!=nums[i]){
                new_length++;
                nums[new_length]=nums[i];
            }
        }
        return new_length+1;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums={1,1,2,2,3,4};
        int x=solution.removeDuplicates(nums);
        System.out.println(x);
    }
}
