/**
 * Created by ASUS on 2015/10/11.
 */
public class Solution {
    public int reverse(int x) {
        int remainder=0;
        long result=0;
        while(x!=0){
            remainder=x%10;
            result*=10;
            x=x/10;
            result+=remainder;
            if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
                result=0;break;
            }
        }
        return (int)result;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        long x=s.reverse(-123);
        System.out.println(x);
    }
}
