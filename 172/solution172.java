package debug;
//n!后面会有几个0，那就看有几个5了：每个5遇到2（比5多）就会出一个0
//SUM(N/5^1, N/5^2, N/5^3...)
public class solution172 {
	public static int trailingZeroes(int n) {
	      int result=0;
	      while (n!=0) {
			result = result + n/5;
			n = n/5;
		}
	      return result;
	}
	public static void main(String[] args) {
		System.out.println(trailingZeroes(26)); 
	}
}
