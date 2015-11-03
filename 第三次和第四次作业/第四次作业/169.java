/**
 * Created by ASUS on 2015/11/2.
 */
public class Solution {
    public int majorityElement(int[] nums){
        int major_element=0;int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                major_element=nums[i];
                count++;
            }
            else {
                if(major_element==nums[i])
                    count++;
                else
                    count--;
            }
        }
        return major_element;
    }
    public static void main(String[] args){
        int[] nums={3,3,4};
        Solution solution=new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
