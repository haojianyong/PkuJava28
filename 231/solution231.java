package debug;
//判断一个数是否为2的次方数
public class solution231 {
	public static boolean isPowerOfTwo(int n) {
        boolean result=false;
        if (n<=0) return false;
        
        int m = 0;
        while (m == 0 && n != 0) {
        	m = n % 2;
        	n = n / 2;
			
		}
        if (n==0) 
			result = true;
		
        return result;
    }
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(0));
	}
}
