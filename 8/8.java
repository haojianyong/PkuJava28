/**
 * Created by ASUS on 2015/10/3.
 */
public class Solution {
    public int myAtoi(String str) {
        int symbol=-1;//正负标志
        int index=-1;//有效位置
        int result=0;//返回值
        str=str.trim();
        if(str.isEmpty())
            return 0;
        char[] tochar=str.toCharArray();
        if (tochar[0]=='-')
            symbol=0;
        else if(tochar[0]=='+')
            symbol=1;
        else
            symbol=2;
        if(symbol==2){
            for(int i=0;i<tochar.length;i++){
                if(tochar[i]>='0'&&tochar[i]<='9')
                    continue;
                else{
                    index=i;
                    break;
                }
            }
        }
        else {
            for(int i=1;i<tochar.length;i++){
                if(tochar[i]>='0'&&tochar[i]<='9')
                    continue;
                else{
                    index=i;
                    break;
                }
            }
        }
        if(index!=-1) {
            str=str.substring(0,index);
            System.out.println("jiquguode"+str);
        }
        if(str.isEmpty()||str.endsWith("+")||str.endsWith("-")){
            return 0;
        }
        else{
            try {
                result=(int)Integer.parseInt(str);
            }catch (NumberFormatException e) {
                if(symbol==0)
                    result=Integer.MIN_VALUE;
                else
                    result=Integer.MAX_VALUE;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int i=s.myAtoi("-+2");
        System.out.println(i);
    }
}
