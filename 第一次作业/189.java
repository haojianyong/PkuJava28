public class Solution {
    void reverse(int[] nums,int start,int end){
        if(start>=end)return;
        int i=start,j=end,t;
        while(i<j){
            t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int l=nums.length;
        k=k%l;
        reverse(nums,0,l-k-1);
        reverse(nums,l-k,l-1);
        reverse(nums,0,l-1);
    }
}
