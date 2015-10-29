/**
 * Created by ASUS on 2015/9/28.
 */
public class Solution {
    public boolean isHappy(int n) {
        if(n==0)
            return false;
        boolean flag=true;
        int[] m=new int[1000];
        for(int i=0;i<1000;i++)
            m[i]=0;
        int begin=0;
        while(n!=1){
            n=add(n);
            //System.out.println(n+"+++++++");
            if (find(m,n)>0){
                flag=false;
                break;
            }
            m[begin++]=n;
        }
        return flag;
    }
    int find(int[] m,int n){
        int flag=0;
        for(int i=0;i<m.length&&m[i]!=0;i++)
            if(m[i]==n)
            {
                //System.out.println(n+"beizhaodeshu");
                flag=1;break;
            }
        if(flag==1)
            return 1;
        else
            return 0;
    }
    int add(int n){
        int result=0;
        while(n!=0){
            int a=n%10;
            result=result+a*a;
            n/=10;
        }
        return result;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        System.out.println(s.isHappy(0));
    }
}
