public class Solution {
    public void moveZeroes(int[] nums) {
        int p1=0,p2=0,cnt=0;
        while(p1<nums.length&&p2<nums.length){
            while(p1<nums.length&&nums[p1]!=0){
                p1++;
            }
            if(p1>=nums.length)return;
            p2=p1;
            while(p2<nums.length&&nums[p2]==0){
                p2++;
            }
            if(p2>=nums.length)return;
            nums[p1]=nums[p2];
            nums[p2]=0;
        }
    }
}
