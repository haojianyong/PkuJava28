/**
 * Created by ASUS on 2015/10/11.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int element:nums){
            if(element!=val)
                nums[count++]=element;
        }
        return count;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int [] num={};
        System.out.println(s.removeElement(num,0));
    }
}
