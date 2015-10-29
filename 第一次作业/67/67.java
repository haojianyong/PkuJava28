/**
 * Created by ASUS on 2015/9/25.
 */
public class addbinary {
    public String addBinary(String a, String b) {
        int absolute = a.length() - b.length();
        String result="";
        if (absolute <0) {
            String tem=a;
            a=b;
            b=tem;
        }
        System.out.println(a+"and"+b);
        char[] a_ch = a.toCharArray();
        char[] b_ch = b.toCharArray();
        char[] c_ch = new char[a.length()];
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        int flag = 0;//进位标志
        if (b_index < 0)
             result=a;
        else {
            for (int i = 0; b_index >= 0; i++) {
                int a_toint = a_ch[a_index]-'0';
                int b_toint = b_ch[b_index]-'0';//分别把数组中的字符转换为数字
                int res = a_toint + b_toint + flag;//各位相加的临时结果
                if (res > 1) {
                    c_ch[i] = (char) ('0'+res % 2);
                    flag = 1;
                } else {
                    c_ch[i] = (char) ('0'+res % 2);
                    flag = 0;
                }
                a_index--;
                b_index--;
            }

            for (int i = b.length(); a_index >= 0; i++) {
                int a_toint = a_ch[a_index]-'0';//分别把数组中的字符转换为数字
                int res = a_toint + flag;//各位相加的临时结果
                if (res > 1) {
                    c_ch[i] = (char) ('0'+res % 2);
                    flag = 1;
                } else {
                    c_ch[i] = (char) ('0'+res % 2);
                    flag = 0;
                }
                a_index--;
            }
            if (flag == 1) {
                char[] new_c_ch = new char[a.length() + 1];
                for(int i=0;i<a.length();i++){
                    new_c_ch[i]=c_ch[i];
                }
                new_c_ch[a.length()] = '1';
                result= new StringBuffer(new String(new_c_ch, 0, a.length() + 1)).reverse().toString();
            } else
                result= new StringBuffer(new String(c_ch, 0, a.length())).reverse().toString();
        }
        return result;
    }
    public static void main(String[] args){
        addbinary ad=new addbinary();
        System.out.println(ad.addBinary("100", "110010")+"jieguo");
    }

}
