public class Solution {
    public int climbStairs(int n) {
        if(n==1)return 1;
	if(n==2)return 2;
    	int a=1,b=2;
    	while(n>2){
        	b=a+b;
        	a=b-a;
        	n--;
	}
    	return b;
    }
}
