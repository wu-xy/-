package cn.wzx.algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
 
 /**
  * ��������:
	s ="catsanddog"
	dict ="cat", "cats", "and", "sand", "dog"
	
	�������:
	[cats and dog, cat sand dog] 
  *
  */
 
public class possibleSentences {
 
    //����python�󷨺ð���ʮ����....
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine().trim().split("\"")[1];		//ȡ�и���ַ�������ĵڶ���
        String[] split = bf.readLine().trim().split("\"");
        HashSet<String> dic = new HashSet<>();
        for (int i = 0; i < split.length; i++) {		//ȡ�и���ַ��������1,3,5,...	
            if (i % 2 != 0) {
                dic.add(split[i]);
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        backtrack(dic, new StringBuilder(), s, ans);
        //��������ַ�����ƴ����..........
        if (ans.size() == 0){
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ans.size() - 1; i++){
            String s1 = ans.get(i);		//������������һ���ո�,Ҫ�и��
            sb.append(s1.substring(0,s1.length()-1)).append(',').append(" ");
        }
        String s2 = ans.get(ans.size()-1);		//��������ԡ�]����β
        sb.append(s2.substring(0,s2.length()-1)).append(']');
        System.out.println(sb.toString());
    }
 
    //�ܱ�׼�Ļ����㷨
    private static void backtrack(HashSet<String> dic, StringBuilder sb, String s, ArrayList<String> list) {
        if (s.isEmpty()) {		//���ԭʼ�ַ������ȹ��㣬˵��������
            list.add(sb.toString());	//�������ϵľ�����ӵ�list������
            sb.delete(0, sb.length());	//��ϳɹ��ǵ�����
            return;
        }
        for (String item : dic) {
            if (s.startsWith(item)) {	//�ж��Ƿ��ǿ�ͷ����
            	//����ǵĻ�������������ó���������ԭʼ�ַ�����ɾ���������ݹ�
                backtrack(dic, sb.append(item).append(" "), s.substring(item.length()), list);
            }
        }
    }
}