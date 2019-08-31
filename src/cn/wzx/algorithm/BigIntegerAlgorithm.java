package cn.wzx.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 给定两个数字（0-9）字符串（长度不限）求它们的乘积。
 * @author Administrator
 *
 */
public class BigIntegerAlgorithm {
			
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger bi1 = new BigInteger(scanner.next());
        BigInteger bi2 = new BigInteger(scanner.next());
        System.out.println(bi1.multiply(bi2));
        
		    }
		}
