package debug;

import java.util.HashMap;
import java.util.Map;

public class solution1 {
	public int[] twoSum(int[] numbers, int target) {
        int i ;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(i=0;i<numbers.length;i++){
        	//2.........7   target 9,target-2=7入map，最后一定会遇到7
        	if(m.containsKey(numbers[i])){
        		int[] result={m.get(numbers[i])+1,i+1} ; 
        		return result;
        		}
        	else {
        		//m.put(i, target-numbers[i]);//map结构 （index，值）——> key 应该是值
        		m.put(target-numbers[i], i);
			}
        }
//        for(i = 0;i < numbers.length; i++){
//        	for(j = 0;j<numbers.length;j++){
//        		while (i!=j && numbers[i]+numbers[j]==target) {
//					result[0]=i;
//					result[1]=j;
//        			return result;
//				}
//        	}
//        }
        int[] result={};
        return result;
    }


}
