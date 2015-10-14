public class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
        	if(hm.containsKey(target-nums[i])){
        		res[0]=hm.get(target-nums[i]);
        		res[1]=i+1;
        		return res;
        	}
        	if(!hm.containsKey(nums[i])){
        		hm.put(nums[i], i+1);
        	}
        }
        return null;
    }
}
