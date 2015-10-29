/**
 * Created by ASUS on 2015/9/26.
 */
public class Solution1 {
    public int lengthOfLastWord(String s) {
        if(s.length()<1)
            return 0;
        int flag=0;
        int count=0;
        for(int i=s.length()-1;i>=0;i--) {
            if(flag==0){
                if (s.charAt(i)!=' '){
                    flag=1;count++;
                }
                else
                    continue;
            }
            else if(flag>0){
                if(s.charAt(i)!=' '){
                    flag=1;count++;
                }
                else
                    break;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String c="a ";
        Solution1 s=new Solution1();
        System.out.println(c.length());
        int x=s.lengthOfLastWord(c);
        System.out.println(x);
    }
}
