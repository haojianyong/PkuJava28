/**
 * Created by ASUS on 2015/10/11.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s=s.trim();
        if(s==""){
            System.out.println("sjkaska");
            return true;
        }
        char [] s_tochar=s.toCharArray();
        int count=0;
        for (char element:s_tochar){
            if((element>='A'&&element<='Z')||(element>='a'&&element<='z')||(element>='0'&&element<='9'))
                s_tochar[count++]=element;
        }
        int start=0,end=count-1;
        while(start<end){
            if(s_tochar[end]==s_tochar[start]||(s_tochar[end]-32)==s_tochar[start]||(s_tochar[end]+32)==s_tochar[start]){
                start++;end--;
            }
            else
                break;
        }
        if(start>=end)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String str="A man, a plan, a canal: Panama";
        String str1="race a car";
        String str2="";
        String str3="1a2";
        System.out.println(s.isPalindrome(str3));
    }
}