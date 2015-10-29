/**
 * Created by ASUS on 2015/9/26.
 */
public class Solution {
    public void sortColors(int[] nums) {
        int[] a={0,0,0};
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                a[0]++;
            }
            if(nums[i]==1)
                a[1]++;
            else if(nums[i]==2)
                a[2]++;
        }
        for(int i=0;i<a[0];i++)
            nums[i]=0;
        for(int i=a[0];i<a[0]+a[1];i++)
            nums[i]=1;
        for(int i=a[0]+a[1];i<nums.length;i++)
            nums[i]=2;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={0};
        s.sortColors(nums);
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
    }
}
