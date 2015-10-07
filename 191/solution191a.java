package debug;

public class solution191a {
	public int hammingWeight(int n) {
        int result = 0;				//记录1的个数
		while (n != 0) {
            n = n&(n-1);
            result ++;
        }
		  return result;		
    }
}
