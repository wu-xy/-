package cn.wzx.algorithm;
import java.util.*;

/**
 * ����һ���ַ��������ֻ��Сд��ĸ��, �ҳ���ĶԳƵ��Ӵ������ж�����������һ������
	���磺
	���룺��abbaad��
	�������abba��
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
     * ˼·�ǣ���ȷ�����������������죬���Ĵ������֣�
	�����ĵ������ַ���һ���ģ���"abccba"��
	������ֻ��һ���ַ�����"abcba"��

	��������������Ҫ�ֱ�����
	����Ե�һ�֣�ÿ���ַ������������ģ�
	����Եڶ��֣��������ҵ�"cc"����ͨ��s[i] == s[i - 1]�������ж��ҵ�����c�е�ĳһ����Ȼ���������������ҡ�
     
     */   
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}