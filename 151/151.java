/**
 * Created by ASUS on 2015/9/28.
 */
public class Solution {
    public String reverseWords(String s) {
        int begin=s.length()-1;
        int end=begin;
        String word="";
        while(begin>=0){
            while(s.charAt(end)==' '&&end>0){
                end--;
                //System.out.println(end+"end");
            }
            begin=end;
            //System.out.println(end+"and"+begin);
            while(s.charAt(begin)!=' '&&begin>0){
                begin--;
                //System.out.println(begin+"beigin");
            }
            //System.out.println(begin+"bubian");
            if (begin==0)
                word+=s.substring(begin,end+1);
            else
                word+=s.substring(begin+1,end+1);
            word+=' ';
            //System.out.println(word);
            begin--;
            end=begin;
        }
        //System.out.println(word);
        word=word.trim();
        //System.out.println(word);
            return word;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String l="  a  b ";
        //String l="a";
        //String l="hello world";
        System.out.println(l.length());
        System.out.println(s.reverseWords(l));
    }
}
