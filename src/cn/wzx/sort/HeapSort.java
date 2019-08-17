package cn.wzx.sort;
/**
 * ������
 * ��˳���������ʵ��
 * @author Administrator
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] data=new int[] {8,1,9,7,8,593,53,11,23,156,308,15,0,4,6,7,40,36,106};
		heapSort(data);
		BubbleSort.arrToString(data);
	}
	
	
	public static void heapSort(int[]data) {
		int size=data.length;
		for(int i=size;i>0;i--) {
			heap(data, i, 0);
			int temp=data[0];
			data[0]=data[i-1];
			data[i-1]=temp;
		}
	}
	
	/**
	 * ���������Ϊ���
	 * @param data	��������
	 * @param size	����Χ
	 * @param index	��ʼ�����λ��
	 */
	public static void heap(int[]data,int size,int index) {
		if(data!=null) {
			int leftNode=2*index+1;		//���ӽڵ�
			int righttNode=2*index+2;	//���ӽڵ�
			//�ж�����ڵ��Ƿ����
			if(4*index+3<size) {
				heap(data,size,leftNode);
			}
			//�ж�����ڵ��Ƿ����
			if(4*index+4<size) {
				heap(data,size,righttNode);
			}
			int max=index;
			if(leftNode<size&&data[leftNode]>data[max]) {		//�ж����ӽڵ��Ƿ�ϴ�
				max=leftNode;
			}
			if(righttNode<size&&data[righttNode]>data[max]) {	//�ж����ӽڵ��Ƿ�ϴ�
				max=righttNode;
			}
			if(max!=index) {			//������ֵ�ѱ�
				int temp=data[index];
				data[index]=data[max];
				data[max]=temp;
				heap(data,size,max);
			}
			
		}
	}
	
	
	
}
