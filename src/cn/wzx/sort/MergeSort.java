package cn.wzx.sort;
/**
 * �鲢����
 * ʹ�õݹ�
 * @author Administrator
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,53,11,23,15,0,4,6,7,40,10};
		merge(intarr,0,intarr.length-1);
		BubbleSort.arrToString(intarr);
		
	}
	
	/**
	 * 
	 * @param intarr ��������
	 * @param low	 ��ʼλ��
	 * @param high	����λ��
	 */
	public static void merge(int[] intarr,int low,int high) {
		if(low<high) {
			int[] temp=new int[high-low+1];		//�½�һ������������
			int mid=(low+high)/2;				//ȡ�м�λ��
			merge(intarr,low,mid);			//�ȷ���������������黹�ָܷ�ͼ����ָ�
			merge(intarr,mid+1,high);
			int index=0;
			int i = low,j=mid+1;			//��Ϊ�������飬��һ�������0��ʼ���ڶ�������м�λ��+1��ʼ
			while (i <= mid&&j<=high) {		//��֤��һ����Ľ���λ��Ϊ�м�λ�ã��ڶ�������Ľ���λ��Ϊ����Ľ���λ��
				if(intarr[i]<=intarr[j]) {
					temp[index]=intarr[i];
					i++;					//�ж������������ֵ��С�����ΰ� ��ֵ��ӵ���������
				}else {
					temp[index]=intarr[j];
					j++;
				}
				index++;
			}
			while(i <= mid) {		//���������ұ����鳤�����
				temp[index]=intarr[i];
				i++;
				index++;
			}
			while(j<=high) {		//�ұ������������鳤�����
				temp[index]=intarr[j];
				j++;
				index++;
			}
			for (int j2 = 0; j2 <temp.length; j2++) {	//���ź����������µ�Ԫ������
				intarr[j2+low]=temp[j2];
			}
		}
		
	}
	
	
}
