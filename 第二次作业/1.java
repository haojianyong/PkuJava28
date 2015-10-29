/**
 * Created by ASUS on 2015/10/11.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result={0,0};
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            boolean flag=false;
            for(int j=i+1;j<nums.length;j++){
                if(temp==nums[j]){
                    result[0]=i+1;result[1]=j+1;flag=true;
                    break;
                }
            }
            if(flag==true)
                break;
        }
        return result;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int []numbers={-1, -2, -3, -4,-5};
        int target=-8;
        int[] result=s.twoSum(numbers,target);
        System.out.println(result[0]);
        System.out.println(result[1]+"jieguo");
    }
}