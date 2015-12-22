package debug;
//统计小于非负整数n的素数的个数
//Sieve of Eratosthenes
public class solution204 {
	public static void main(String[] args){
		int m = countPrimes (9);
		System.out.println(m);
	}
	public static int countPrimes(int n) {
	        int count = 0;
	        boolean[] a = new boolean[n];//默认是false
	        for(int i=2;i*i<n;i++){
	        	if (a[i]==false) {
					for (int j = i;i*j<n; j++) {
						a[i*j] = true;//划掉的
					}
				}
	        }
	        for(int m =2;m<n;m++){
	        	if (a[m]==false) {
					count++;
				}
	        }
	        
	        return count;
	    }
	
}

