package cn.wzx.algorithm;
import java.util.*;

/**
 * 给定一个字符串（数字或大小写字母）, 找出最长的对称的子串（如有多个，输出任意一个）。
	例如：
	输入：“abbaad”
	输出：“abba”
 * @author Administrator
 *
 */
public class LongStringReturn {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solve(input));
    }
 
    public static String solve(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
 
    /**
     * 思路是：先确定中心再向两边延伸，回文串有两种：
	①中心的两个字符是一样的，如"abccba"；
	②中心只有一个字符，如"abcba"。

	所以针对两种情况要分别来求：
	①针对第一种，每个字符都可以是中心；
	②针对第二种，必须先找到"cc"，即通过s[i] == s[i - 1]这样的判断找到两个c中的某一个，然后向两边延伸着找。
     
     */   
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}