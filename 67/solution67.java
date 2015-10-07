package debug;


public class solution67 {
	public static void main(String[] args) {
		String a="10";
		String b="111";
		String c = addBinary(a,b);
		System.out.println(c);
	}

	public static String addBinary(String a, String b) {
		int i = a.length() ;		// i记录a的长度
        int j = b.length() ;		// j记录b的长度
        int k = (i>j?i:j)+1;		// k记录加法最多次数
        int c = 0;					// c记录进位情况
        int m ;						// 用来循坏
        String result = "";
        for (m = 0; m < k; m++) {
        	int p=0;				// 用来记录每一位的数
        	int q=0;				// 用来记录每一位的数
        	if(m<i)					// 如果有位数可加
        	    p = a.charAt(i-1-m) - '0';// 获取这位转换成整型
        	else
        	    p = 0;				//记为0
        	if(m<j)					
        	    q = b.charAt(j-1-m)-'0';// 获取这位转换成整型
        	else
        	q = 0;					//记为0
        	int temp = p + q + c;	//临时记录一下每位的和可能是0，1，2
        	c = temp / 2;			//生成下一位进位
            result = temp % 2+result;		//生成本位的值

         }

         return (c == 0) ? result : "1" + result;
	}

}
