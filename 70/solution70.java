package debug;
//N个台阶每次走一到两步，有几种走法
//动态规划思想：f(1)=1  f(2)=2  f(n)=f(n-2)+f(n-1)
public class solution70 {
	public static void main(String[] args) {
		int n;
		n=climbStairs(2);
		System.out.println(n);
	}
	 public static int climbStairs(int n) {
		 int result=0;
		 int f0=1,f1=1;
		 if (n<0) {
			return 0;
		 }
		 if (n <= 1) {
			return 1;
		}
//		 result = climbStairs(n-2)+climbStairs(n-1);
		 for (int i = 2; i <=n; i++) {
			result = f1 + f0;
			f0 = f1;
			f1 = result;
			
		}
		 return result;
	 }
}
