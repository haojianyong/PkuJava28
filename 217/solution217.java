package debug;

import java.util.HashSet;
import java.util.Set;

public class solution217 {
	public static boolean containsDuplicate(int[] nums) {
        boolean d =false;
        Set<Integer> a = new HashSet<Integer>(); 
        for (int i = 0; i < nums.length; i++) {
			if (a.contains(nums[i])) {
				d=true;
			}
			else {
				a.add(nums[i]);
			}
		}
        return d;
    }
	public static void main(String[] args) {
		int[] nums={1,2,3,4,5};
		System.out.println(containsDuplicate(nums));
	}
}
