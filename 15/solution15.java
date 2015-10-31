package debug;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class solution15 {//怎么去重？？？？？只在后面的数组里找数对
	public static void main(String[] args) {
		int[] nums={-1,0,1,2,-1,-3};
		List<List<Integer>> l=new ArrayList<List<Integer>>();
		l=threeSum(nums);
		System.out.println(l);
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> l=new ArrayList<List<Integer>>(); //用来存放结果
		if (nums == null || nums.length < 3) return l; 
		Arrays.sort(nums);//排序
//		for(int m =0;m< nums.length-2;m++){//遍历到倒数第三个就好了
//			if(m!=0 && nums[m]==nums[m-1])//有相同的只算一个
//				continue;
//			int i=m+1;
//			int j=nums.length-1;
//			while (i<j) {//找数对的时候也要去掉重复
//				if (i>m+1 && nums[i]==nums[i-1]) {
//					
//					i++;
//					continue;
//				}
//				if (j<nums.length-2 && nums[j]==nums[j+1]) {
//					
//					j--;
//					continue;
//				}
//				if (nums[i] + nums[j] + nums[m] == 0) {
//					List<Integer> list = new ArrayList<>();
//					list.add(nums[i]);
//					list.add(nums[j]);
//					list.add(nums[m]);
//					l.add(list);
//					i++;
//					j--;
//				}
//				else if (nums[i] + nums[j] + nums[m] > 0) {
//					j--;
//				}
//				else {
//					i++;
//				}
//				
//				
//			}
//		}
	
//		
//		int i;
//        int[] m = new int[nums.length]; 
//        for (i = 0; i < nums.length; i++) {
//			m[i]=0-nums[i];
//		}
//        List<Integer> list = new ArrayList<>();
//		for(i=0;i<nums.length;i++) {
//			list = twoSum(nums, m[i]);
//			if (list !=null) {
//				list.add(nums[i]);
//				l.add(list);	
//			}
//			return l;
//		}
		return l;
		
    }
//	public static List<Integer> twoSum(int[] numbers, int target) {
//        int i ;
//        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//        for(i=0;i<numbers.length;i++){
//        	if(m.containsKey(numbers[i])){
//        		List<Integer> list=new ArrayList<Integer>();
//        		list.add(numbers[m.get(numbers[i])]);
//        		list.add(numbers[i]);
//        		return list;
//        		}
//        	else {
//        		m.put(target-numbers[i],i);
//			}
//        }
//        List<Integer> list=new ArrayList<Integer>();
//        return list;
//    }
}
