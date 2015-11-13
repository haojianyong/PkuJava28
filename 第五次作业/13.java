/**
 * Created by ASUS on 2015/11/12.
 */
public class Solution {
    public int romanToInt(String s) {
        if(s.length()<1)
            return 0;
        int result=0;
        int last=s.charAt(0);
        for (int i=0;i<s.length();i++){
            int current=romanchar_to_int(s.charAt(i));
            result+=current;
            if(i>0){
                last=romanchar_to_int(s.charAt(i-1));
                if (current>last){
                    result-=2*last;
                }
            }
        }
        return result;
    }

    int romanchar_to_int(char remoan_char){
        switch (remoan_char){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
    public static void main(String[] args){
        String s="MMMCMXCIX";
        Solution solution=new Solution();
        int x=solution.romanToInt(s);
        System.out.println(x);
    }
}
