package cn.wzx.algorithm;

import java.util.*;
 
/**
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 * 请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 * 
 * 就是一个排列组个问题  一共要走x+y步，从中任选X步向下走或任选Y步向右走
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