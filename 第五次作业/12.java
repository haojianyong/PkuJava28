/**
 * Created by ASUS on 2015/11/12.
 */
//本题和ccf计算年月日同样的方法
public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] Roman_num={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        String s=new String();
        for(int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(Roman_num[i]);
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        String s=solution.intToRoman(3999);
        System.out.println(s);
    }
}
