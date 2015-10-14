/**
 * Created by ASUS on 2015/10/14.
 */
public class Solution {
    public int addDigits(int num){
        while(num/10!=0){
            num=compute(num);
            //System.out.println(num);
        }
        return num;
    }
    int compute(int x){
        int result=0;
        while(x!=0){
            result+=x%10;
            x/=10;
        }
        return result;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        System.out.println(s.addDigits(38));
    }
}
