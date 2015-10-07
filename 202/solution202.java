package debug;
import java.util.* ;

public class solution202 {
	public static void main(String[] args) {
		int a= 19;
		
		Boolean c = isHappy(a);
		System.out.println(c);
	}
	public static boolean isHappy(int n) {
		//int sum = 0;				//sum每次计算完要清零！！！怎么在这定义
		Set<Integer> s = new HashSet<Integer>();
			while(n !=1){       	 //当平方和不为1的时候,要继续计算下一个数的平方和
				int sum = 0;		 //用来存储各个位平方的值
				while (n!=0) {    	 //各个位相加的和存储在sum中
					sum += (n % 10)*(n % 10);
					n /= 10;
				}
				if(s.contains(sum))  //说明又循环到了这个数
	    			return false;
	    		s.add(n=sum);		//记录已经求过的数
				//s.add(sum);
			}
		return true;
	}

}
