/**
 * Created by ASUS on 2015/9/26.
 */
public class Solution3 {
    public void reverse(int[] nums,int start,int end){
        int temp = 0;
        while(start<end&& start>= 0){
            temp= nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            temp--;
        }
    }
    public void rotate(int[] nums, int k) {
        if (k<=0||nums.length==k)
            return;
        if(nums.length<k)
        {
            k=k% nums.length;
            if(k==0)
                return;
            else{
                reverse(nums,0,nums.length-k-1);
                reverse(nums,nums.length-k,nums.length-1);
                reverse(nums,0,nums.length-1);
            }
        }
        else {
            reverse(nums,0,nums.length-k-1);
            reverse(nums,nums.length-k,nums.length-1);
            reverse(nums,0,nums.length-1);
        }
    }
    public static void main(String[] args){
        // int[] nums={8,2,0,4,1,4,2,1,0,6,6,2,5,6,6};
        // Solution s=new Solution();
        //s.rotate(nums, 11939);
        // System.out.println(nums.length);
        //for(int i=0;i<nums.length;i++)
        //System.out.println(nums[i]);
    }
}