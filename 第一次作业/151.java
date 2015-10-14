public class Solution {
    public static String reverseWords(String s) {
        String[] t=s.split(" ");
        if(t.length==0)return "";
        StringBuffer sb=new StringBuffer();
        System.out.println(t.length);
        int i;
        for(i=t.length-1;i>=0;i--){
        	if(!t[i].equals("")){
        		if(sb.length()!=0)sb.append(' ');
        		sb.append(t[i]);
        	}
        }
        return sb.toString();
    }
}
