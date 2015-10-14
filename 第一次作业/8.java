public class Solution {
    public int myAtoi(String str) {
        int i,sign=1;
        for(i=0;i<str.length()&&str.charAt(i)==' ';i++){}
        if(i>=str.length())return 0;
        if(str.charAt(i)=='+'){
            sign=1;
            i++;
        }
        else if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        if((str.charAt(i)-'0'<0||str.charAt(i)-'0'>9)){
            return 0;
        }
        else{
            int sum=0,oldsum;
            char c;
            c=str.charAt(i);
            if(sign==1){
                for(;i<str.length()&&(str.charAt(i)-'0'>=0&&str.charAt(i)-'0'<=9);i++){
                    oldsum=sum;
                    if(sum>2147483647/10)return 2147483647;
                    sum=sum*10+str.charAt(i)-'0';
                    if(sum<oldsum)return 2147483647;
                }
            }
            else if(sign==-1){
                for(;i<str.length()&&(str.charAt(i)-'0'>=0&&str.charAt(i)-'0'<=9);i++){
                    oldsum=sum;
                    if(sum<-2147483648/10)return -2147483648;
                    sum=sum*10-(str.charAt(i)-'0');
                    if(sum>oldsum)return -2147483648;
                }
            }
            return sum;
        }
    }
}
