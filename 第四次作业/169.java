public class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0,val=0;
        int i;
        for(i=0;i<nums.length;i++){
            if(cnt==0){
                val=nums[i];
            }
            if(val==nums[i])cnt++;
            else cnt--;
        }
        cnt=0;
        for(i=0;i<nums.length;i++){
            if(val==nums[i])cnt++;
        }
        if(cnt>nums.length/2)return val;
        else return 0;
    }
}
