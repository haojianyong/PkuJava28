package debug;
public class solution26 {//注意数组排好序
	public static int removeDuplicates(int[] nums) {
		int length=1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]!=nums[length-1]) {
				nums[length] = nums[i];
				length++;
			}
			else {
				
			}
		}
		return length;
    }
	public static void main(String[] args) {
		int[] nums={1,1,2,4};
		System.out.println(removeDuplicates(nums)); 
	}
}
