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
	public static int charToInt(char c) {//单个符号的转换
        int result = 0;
        switch (c) {
            case 'I':
                result = 1;
                break;
            case 'V':
                result = 5;
                break;
            case 'X':
                result = 10;
                break;
            case 'L':
                result = 50;
                break;
            case 'C':
                result = 100;
                break;
            case 'D':
                result = 500;
                break;
            case 'M':
                result = 1000;
                break;
        }

        return result;
    }
	public static int romanToInt(String s) {//罗马转换数字
		int i, total, pre, cur;
		//charAt(int index)方法是一个能够用来检索特定索引下的字符的String实例的方法.
        total = charToInt(s.charAt(0));

        for (i = 1; i < s.length(); i++) {
            pre = charToInt(s.charAt(i - 1));
            cur = charToInt(s.charAt(i));

            if (cur <= pre) {
                total += cur;//小在大的右边，等于大+小，例如：VIII = 8
            } else {
                total = total - pre * 2 + cur;
            }
        }
        return total;
	}
	public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}