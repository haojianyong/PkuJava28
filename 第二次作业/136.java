/**
 * Created by ASUS on 2015/10/13.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int element:nums){
            result=result^element;
        }
        return result;
    }
}