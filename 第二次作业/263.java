/**
 * Created by ASUS on 2015/10/14.
 */
public class Solution {
    public boolean isUgly(int num){
        if (num<=0)
            return false;
        while (num%2==0)
            num=num/2;
        while (num%3==0)
            num=num/3;
        while (num%5==0)
            num=num/5;
        return num==1;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        System.out.println(s.isUgly(905391974));
    }
}
