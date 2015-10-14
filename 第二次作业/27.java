public class Solution {
    public int removeElement(int[] nums, int val) {
        int s=0,i=0,j=0;
    while(i<nums.length&&j<nums.length){
        if(nums[i]!=val){
            nums[s++]=nums[i];
            i++;
            continue;
        }
        else{
            j=i+1;
            while(j<nums.length&&nums[j]==nums[i]){j++;}
            if(j<nums.length){
                i=j;
            }
            else break;
        }
    }
    return s;
    }
}
