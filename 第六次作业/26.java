public class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0,val,cnt=0;
        while(i<nums.length&&j<nums.length){
            val=nums[i];
            nums[cnt++]=val;
            j=i+1;
            while(j<nums.length&&nums[j]==val){j++;}
            i=j;
        }
        return cnt;
    }
}
