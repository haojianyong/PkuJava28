/**
 * Created by ASUS on 2015/10/31.
 */
//实际上就是计算斐波那契数列的第n个数
public class Solution3 {
    public int climbStairs(int n){
        if(n<=2)
            return n;
        else {
            int first=1,second=1;
            for (int i=2;i<=n;i++){
                int thrid=first+second;
                first=second;
                second=thrid;
            }
            return second;
        }
    }
    public static void main(String[] args){
        Solution3 solution=new Solution3();
        System.out.println(solution.climbStairs(4));
    }
}
