/**
 * Created by ASUS on 2016/1/8.
 */
public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0 );
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.isPowerOfTwo(5));
    }
}
