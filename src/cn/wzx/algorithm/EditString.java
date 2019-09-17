package cn.wzx.algorithm;
import java.util.Scanner;

/**
 * �ҽ����󴸣���һ�ҳ�����ı༭���Ҹ���У��Ͷ������Ӣ�ĸ������ݹ����ǳ����ˣ���Ϊÿ�춼Ҫȥ����������ƴд����
 * ���ǣ��������������ƽ���Ĺ����з��������ҷ���һ������ƴд����Ľݾ���
1. ����ͬ������ĸ����һ��һ����ƴд����ȥ��һ���ľͺ��������� helllo -> hello
2. ����һ������ĸ��AABB�ͣ�����һ��һ����ƴд����ȥ���ڶ��Ե�һ����ĸ�ͺ��������� helloo -> hello
3. ����Ĺ������ȡ������ҡ�ƥ�䣬�������AABBCC����ȻAABB��BBCC���Ǵ���ƴд��Ӧ�����ȿ����޸�AABB�����ΪAABCC

�������Ǹ���ţ���������ѧ���ھ���ͳ�����ƣ��������ԭ��д��һ���Զ�У����������Ч�ʴӴ���ɡ��ò��˶�ã�
�Ҿͻ����CEO�����϶��³���ӭȢ�׸��������������۷壬���붼�е�С�����أ�
����
����û�뵽���ұ������ˣ�����ʱ�ϰ����˵�� ����������Ҫ����ҵҵ�����ڿҿҡ������ַ֣���Ҫ���У�
��һ����һ�С�һ���������У�Ҫ�ǲ��У���һ�в���һ�У�һ�в������в��С��� �����������˺����л��㱵ġ���
 * @author wzx
 * ��������:��һ�а���һ������N����ʾ���������������ٸ���У����ַ�����
 * �������N�У�ÿ��Ϊһ����У����ַ�����
 *�������:
 *N�У�ÿ�а���һ�����޸�����ַ�����
 */
public class EditString {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);		
		String[] strings =new String[Integer.parseInt(sc.nextLine())];
		for (int i = 0; i < strings.length; i++) {
			strings[i]=sc.nextLine();
		}
		for (int i = 0; i < strings.length; i++) {
			System.out.println(repair(strings[i]));
		}
		
	}

	public static String  repair(String s) {
		if (s == null || s.length() < 1) return "";
		int index=-1;
		for (int i = 0; i < s.length(); i++) {
			index = triple(s, i);         //��Ⲣ�޸������ַ���             
			if(index==i) {
				StringBuilder sb=new StringBuilder(s);
				sb.deleteCharAt(i);
				s=sb.toString();
				i--;
			}
		}       
		for (int i = 0; i < s.length(); i++) {		
			index = doubleTwo(s, i);         //��Ⲣ�޸�˫���ظ��ַ���  
			if(index==i) {
				StringBuilder sb=new StringBuilder(s);
				sb.deleteCharAt(i+2);
				s=sb.toString();
				i--;
			}
		}
		return s;
		
	}

	private static int doubleTwo(String s, int i) {
		if(i>=0&&i+3<s.length()&&s.charAt(i)==s.charAt(i+1)&&s.charAt(i+2)==s.charAt(i+3)) {
			return i;
		}
		return -1;
	}

	private static int triple(String s, int i) {
		if(i-1>=0&&i+1<s.length()&&s.charAt(i)==s.charAt(i-1)&&s.charAt(i)==s.charAt(i+1)) {			
			return i;
		}
		return -1;
	}
			
	
	
}
