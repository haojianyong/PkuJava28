public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<List<Integer>>();
	    for(int i=0;i<nums.length;i++){
	        if(i!=0&&nums[i]==nums[i-1]){
	            continue;
	        }
	        int p,q;
	        p=i+1;
	        q=nums.length-1;
	        while(p<q){
	            if(p!=i+1&&nums[p]==nums[p-1]){
	                p++;
	                continue;
	            }
	            if(nums[i]+nums[p]+nums[q]==0){
	                List<Integer> line=new ArrayList<Integer>();
	                line.add(nums[i]);
	                line.add(nums[p]);
	                line.add(nums[q]);
	                res.add(line);
	                p++;
	                q--;
	            }
	            else if(nums[i]+nums[p]+nums[q]>0){
	                q--;
	            }
	            else{
	                p++;
	            }
	        }
	    }
	    return res;
    }
}
