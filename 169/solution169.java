package debug;

import java.util.Arrays;

//求众数
public class solution169 {
	public int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		return nums[nums.length / 2];
    }
}
