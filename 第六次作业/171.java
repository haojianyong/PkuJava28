/**
 * Created by ASUS on 2015/11/24.
 */
public class Solution {
    public int titleToNumber(String s) {
        if(s.length()==0)
            return 0;
        char[] s_char=s.toCharArray();
        int result=0;
        int power=1;
        for(int i=s_char.length-1;i>=0;i--){
            result+=(s_char[i]-'A'+1)*power;
            power=power*26;
            System.out.println(result);
        }
        return result;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        String s="AB";
        int x=solution.titleToNumber(s);
        System.out.println(x);
    }
}
