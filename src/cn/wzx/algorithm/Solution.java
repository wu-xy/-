package cn.wzx.algorithm;
import java.util.HashMap;

//һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
public class Solution {
    
    //����һ:�ݹ����
	/**
	 * ����ÿһ����Ծֻ������ѡ��:һ������1�����ݵ����n������,
	 * ��ʱС���ܴ��ڵ�n-1������;��������2�����ݵ����n������,��ʱС���ܴ���n-2������,
	 * ����,n�����ݵ���������������ǰn-1�����ݵ���������f(n-1)��ǰn-2�����ݵ���������f(n-2).
	 * ��Ϊֻ�����ֿ�����,����,f(n)=f(n-1)+f(n-2);
		���ƹ�ʽf(n)=f(n-1)+f(n-2):����Ϥ,����쳲������������
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
    
    //������:����¼�㷨
    //�����Ѿ�����Ĵ����������ظ�����
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
    
    //����������������������ݹ飬�������
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