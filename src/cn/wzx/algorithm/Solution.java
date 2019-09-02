package cn.wzx.algorithm;
import java.util.HashMap;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class Solution {
    
    //方法一:递归求解
	/**
	 * 青蛙每一次跳跃只有两种选择:一是再跳1级阶梯到达第n级阶梯,
	 * 此时小青蛙处于第n-1级阶梯;或者再跳2级阶梯到达第n级阶梯,此时小青蛙处于n-2级阶梯,
	 * 于是,n级阶梯的跳法总是依赖于前n-1级阶梯的跳法总数f(n-1)和前n-2级阶梯的跳法总数f(n-2).
	 * 因为只有两种可能性,所以,f(n)=f(n-1)+f(n-2);
		递推公式f(n)=f(n-1)+f(n-2):很熟悉,就是斐波那契数列求和
	 */
    public static int JumpFloor1(int n) {
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return JumpFloor1(n-1)+JumpFloor1(n-2);

    }
    
    //方法二:备忘录算法
    //保存已经算过的次数，避免重复计算
    public static int JumpFloor2(int n,HashMap<Integer,Integer> map) {
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            int value=JumpFloor2(n-1, map)+JumpFloor2(n-2, map);	
            map.put(n, value);
            return value;
        }
    }
    
    //方法三：利用数组来避免递归，提高性能
    public static int jumpFloor3(int number) {  
    	int[] total=new int[number+1];        
    	total[0]=0;        
    	total[1]=1;        
    	total[2]=2;        
    	for(int i=3;i<=number;i++) {
    		
    		total[i]=total[i-1]+total[i-2];        
    	}            
    	return total[number]; 
    }
    
    
    public static void main(String[] args){
        HashMap map=new HashMap();
        System.out.println(Solution.JumpFloor1(40));
        System.out.println(Solution.JumpFloor2(40,map));       
        System.out.println(Solution.jumpFloor3(40));
    }

}