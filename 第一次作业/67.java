public class Solution {
    public String addBinary(String a, String b) {
        int lm=a.length()<b.length()?b.length():a.length();
    int[]x=new int[lm+1];
    int[]y=new int[lm+1];
    for(int i=0;i<lm+1;i++){
        x[i]=y[i]=0;
    }
    for(int i=a.length()-1;i>=0;i--){
        x[lm+1-a.length()+i]=a.charAt(i)-'0';
    }
    for(int i=b.length()-1;i>=0;i--){
        y[lm+1-b.length()+i]=b.charAt(i)-'0';
    }
    int flag=0,bit=0;
    for(int i=lm;i>=0;i--){
        bit=flag+x[i]+y[i];
        if(bit==3){
            flag=1;
            bit=1;
        }
        else if(bit==2){
            bit=0;
            flag=1;
        }
        else if(bit==1){
            flag=0;
            bit=1;
        }
        else if(bit==0){
            flag=0;
            bit=0;
        }
        x[i]=bit;
    }
    String res="";
    int i=0;
    while(i<=lm&&x[i]==0){
        i++;
    }
    if(i==lm+1)return "0";
    while(i<=lm){
        res+=((char)('0'+x[i++]));
    }
    return res;
    }
}
