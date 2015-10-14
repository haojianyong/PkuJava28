package debug;
/**
 Given an array and a value, remove all instances of that value in place and return the new length.
 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class solution27 {
	public static void main(String[] args) {
		int nums[] = new int[2];
		nums[0]=4;
		nums[1]=4;
//		nums[2]=4;
//		nums[3]=4;
//		nums[4]=9;
//		nums[5]=4;
		
		System.out.println(removeElement(nums, 4));
	}
//写两个指针，一个从前往后遍历，如果遇到相同的值，和队尾的值交换，队尾指针-1，如果队尾值也是val，直接舍弃，-1再比较。eg.134494
	public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int j = length-1;
        int i = 0;
        while(i<= j){
        	if (nums[i] == val){
        		if (nums[j] != val) {
        			nums[i]=nums[j];
        			i++;
        			j--;
        			length--;
				}
        		else {
        			j--;
        			length--;
        			
        		}
        	}
        	else {
				i++;
			}
        }
        return length;
    }


}
