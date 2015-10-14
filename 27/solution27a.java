package debug;
public class solution27a {
	public static void main(String args[]) {
		int a[] = new int[6];
		a[0]=4;
		a[1]=4;
		a[2]=4;
		a[3]=4;
		a[4]=9;
		a[5]=4;
		System.out.println(removeElement(a,4));
	}
	
	public static int removeElement(int[] nums, int val) {
		int length = nums.length;
		int size = 0;
		for (int i = 0; i < length; i++) {
			if (nums[i]!=val) {
				nums[size++] = nums[i];
			}
		}
		return size;
	}
}	