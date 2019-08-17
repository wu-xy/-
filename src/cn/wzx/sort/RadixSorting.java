package cn.wzx.sort;
/**
 * ��������
 * ����10������0,1,2,3,4��5,6,7,8,9
 * ��һ�ΰѸ�λ��ͬ�ķŵ�ͬһ������
 * �ڶ��ΰ�ʮλ��ͬ�ķŵ�ͬһ������
 * ��������
 * @author Administrator
 *
 */
public class RadixSorting {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,593,53,11,23,156,308,15,0,4,6,7,40,36,106};
		radixSorting1(intarr);
		BubbleSort.arrToString(intarr);
		
	}
	
	public static void radixSorting(int[] intarr) {		//�ö�ά������ʵ��
		int max=0;		//ȡ��������������
		for (int i = 0; i < intarr.length; i++) {
			if(intarr[i]>max) {
				max=intarr[i];
			}
		}
		int n=(max+"").length();	//������Ҫ�ȽϵĴ���
		int[][] temp=new int[10][intarr.length];	//����һ����ά���� 10*�������鳤��
		int[] count=new int[10];			//��¼ÿ������ĳ���
		for (int i = 0,k=1; i < n; i++,k=k*10) {
			
			for (int j = 0; j < intarr.length; j++) {
				int remd=(intarr[j]/k)%10;			//�����λ��ʮλ���߰�λ�ϵ�����
				temp[remd][count[remd]]=intarr[j];
				count[remd]++;
			}
			int index=0;
			for (int l = 0; l < 10; l++) {
				if(count[l]!=0) {
					for (int j = 0; j < count[l]; j++) {
						intarr[index]=temp[l][j];	//��Ԫ�طŻ�ԭ��������
						index++;		
					}
					count[l]=0; 	//ȡ��Ԫ�غ󣬽���¼��������Ϊ0
				}
			}
			
			
		}
		
			
		
	}
	public static void radixSorting1(int[] intarr) { 	//�ö�����ʵ��
		int max=0;		//ȡ��������������
		for (int i = 0; i < intarr.length; i++) {
			if(intarr[i]>max) {
				max=intarr[i];
			}
		}
		int n=(max+"").length();	//������Ҫ�ȽϵĴ���
		Queue[] queue=new Queue[10];	//����1����������
		for (int i = 0; i < queue.length; i++) {
			queue[i]=new Queue();
		}
		for (int i = 0,k=1; i < n; i++,k=k*10) {
			
			for (int j = 0; j < intarr.length; j++) {
				int remd=(intarr[j]/k)%10;			//�����λ��ʮλ���߰�λ�ϵ�����
				queue[remd].add(intarr[j]);
			}
			int index=0;
			for (int j = 0; j < queue.length; j++) {
				while(!queue[j].isEmpty()) {
					intarr[index]=queue[j].pull();
					index++;
				}
			}
			
		}
					
	}
	
}
/**
 * ����
 * �Ƚ��ȳ�
 * �����ĵ����
 * @author Administrator
 *
 */
class Queue{
	int[] temp;
	int length;

	public Queue() {
		this.length=0;
		this.temp = new int[length];
	}
	
	public boolean isEmpty() {
		if(temp.length==0) {
			return true;
		}
		
		return false;
	}
	public void add(int element) {
		length++;
		int[] intarr=new int[length];
		for (int i = 0; i < temp.length; i++) {
			intarr[i]=temp[i];
		}
		intarr[length-1]=element;
		temp=intarr;
	}
	public int pull(){
		int inttemp=temp[0];
		length--;
		int[] intarr=new int[length];
		for (int i = 1; i < temp.length; i++) {
			intarr[i-1]=temp[i];
		}
		temp=intarr;
		return inttemp;
		
	}
	
	
}




