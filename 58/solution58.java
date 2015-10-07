package debug;

public class solution58 {
	public static void main(String[] args) {
		String a="HELLO WORL";
		
		int c = lengthOfLastWord(a);
		System.out.println(c);
	}
	public static int lengthOfLastWord(String s) {
        String [] a = s.split(" ");  				//a存放的是空格后面的字符长度
            for(int i=a.length-1;i>=0;i--){  
                if(a[i].length()>0)  
                    return a[i].length(); 
                
            }  
            return 0;  
        
    }
}
