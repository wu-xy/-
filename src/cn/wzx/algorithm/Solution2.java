package cn.wzx.algorithm;

//һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
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