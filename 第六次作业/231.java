/**
 * Created by ASUS on 2016/1/8.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==2)
            return true;
        double value=n;
        while (value>2){
            value=value/2;
        }
        if(value-2!=0)
            return false;
        return true;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.isPowerOfTwo(5));
    }
}
