package debug;

public class solution171 {
	public static int titleToNumber(String s) {//26进制
        int result = 0;
        //char charAt(int index)返回指定索引处的 char 值
        for (int i = 0; i < s.length(); i++) {
			result=result*26+((int)(s.charAt(i))-64);
		}
        return result;
    }
	public static void main(String[] args) {
		String b="AA";
		System.out.println(titleToNumber(b));
	}
}
