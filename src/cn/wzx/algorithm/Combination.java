package cn.wzx.algorithm;

import java.util.*;
 
/**
 * ��һ��X*Y������С��Ҫ�ڴ������ϴ����Ͻǵ����½ǣ�ֻ���߸����ֻ�����һ������ߡ�
 * �����һ���㷨������С���ж������߷�����������������int x,int y���뷵��С�ŵ��߷���Ŀ��
 * 
 * ����һ�������������  һ��Ҫ��x+y����������ѡX�������߻���ѡY��������
 *
 */
public class Combination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = x + y;
        int b = (x <= y) ? x : y;
        long denominator = 1, numerator = 1;
        for (int i = 1; i <= b; i++, a--) {
            denominator *= i;   // 1*2*3...
            numerator *= a;     // 10*9*8...
        }
        // (10*9*8*...)/(1*2*3*...)
        System.out.println(numerator / denominator);
    }
}