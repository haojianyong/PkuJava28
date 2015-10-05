public class Solution {
    public void sortColors(int[] nums) {
        int start,end,op;
    start=0;
    end=nums.length-1;
    op=start;
    int t;
    while(op<=end){
        if(nums[op]==0){
            t=nums[start];
            nums[start]=0;
            nums[op]=t;
            start++;
        }
        else if(nums[op]==2){
            t=nums[end];
            nums[end]=2;
            nums[op]=t;
            end--;
        }
        else op++;
        if(op<=start)op=start;
    }
    }
}
