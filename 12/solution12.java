package debug;
/** 
	I	V	X	L	C	D	M
	1	5	10	50	100	500	1000
	相同的数字连写例如：III = 3
	小在大的右边，等于大+小，例如：VIII = 8
	小（I、X和C）在大左边，等于大-小，例如：IV = 4
	连续的数字重复不得超过三次
**/
public class solution12 {
	public static String intToRoman(int num) {
		String[][] roman = {
	            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},//1-9
	            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},//10-90
	            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},//100-900
	            {"", "M", "MM", "MMM"}//1000-3000
	        };
	        
	        String result = "";
	        int i = 0;
	        while (num != 0) {
	            int s = num % 10;
	            result = roman[i][s] + result;
	            i++;
	            num /= 10;
	        }
	        
	        return result;

    }
	public static void main(String[] args) {
        System.out.println(intToRoman(51));
    }
}
