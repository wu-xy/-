package cn.wzx.sort;
/**
 * ϣ������
 * �ڲ�������Ļ����ϣ��Ż�
 * @author Administrator
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,53,11,23,4,6,7,40};
		shelltsort1(intarr);
		BubbleSort.arrToString(intarr);
		
	}
	
	public static void shelltsort(int[] intarr) {
		for (int d = intarr.length/2; d > 0; d=d/2) {	//��������з��飬���Ʒ������
			for (int i = d; i < intarr.length; i++) {	//���ѷֺõ�����в�������
				if(intarr[i]<intarr[i-d]) {				//������������ǰ���С�������Ƶ�ǰ��ȥ
					int temp=intarr[i];
					int j;
					for ( j = i-d; j >=0&&temp<intarr[j]; j-=d) {
						intarr[j+d]=intarr[j];	//������������
					}
					intarr[j+d]=temp;			//���ղ����λ��
				}
			}
		}
	}
	
	public static void shelltsort1(int[] intarr) {
		for (int d = intarr.length/2; d > 0; d=d/2) {	//��������з��飬���Ʒ������
			for (int i = d; i < intarr.length; i++) {	//���ѷֺõ�����в�������
				//������������ǰ���С�������Ƶ�ǰ��ȥ
					for ( int j = i-d; j >=0&&intarr[i]<intarr[j]; j-=d) {
						if(intarr[j]>intarr[j+d]) {
							int temp=intarr[j+d];
							intarr[j+d]=intarr[j];
							intarr[j]=temp;
						}
					}
			}
		}
	}
	
}
