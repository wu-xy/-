package cn.wzx.algorithm;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class Solution2 {
      
	 public static int JumpFloorII(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int[] array =new int[target+1];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        for (int i=3;i<array.length;i++){
            array[i]=1;
            for(int j=0;j<i;j++){
                array[i]=array[i]+array[j];
            }
        }
         return array[target];
	    }
    
    
    public static void main(String[] args){      
        System.out.println(Solution2.JumpFloorII(31));
    }

}