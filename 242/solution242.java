package debug;
import java.util.Arrays;
public class solution242 {
	public static boolean isAnagram(String s, String t) {
		//sort之后看是否相等
//		char[] sArr = s.toCharArray();  
//        char[] tArr = t.toCharArray();  
//        Arrays.sort(sArr);  
//        Arrays.sort(tArr);  
//        return String.valueOf(sArr).equals(String.valueOf(tArr));  
        //数字符个数是否相等. 
		
		int[] word=new int[26];//统计每个字母出现次数
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		for (char c : a) {
			word[c-'a']++;
		}
		for (char c : b) {
			word[c-'a']--;
		}
		for (int i = 0; i < word.length; i++) {
			if (word[i]!=0) {
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		
		System.out.println(isAnagram("a","a"));
	}
}
