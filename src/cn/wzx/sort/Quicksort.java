package cn.wzx.sort;
/**
 * ��������
 * ʹ�õݹ�
 * @author Administrator
 *
 */
public class Quicksort {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,53,11,23,4,6,7};
		quicksort(intarr, 0, intarr.length-1);
		BubbleSort.arrToString(intarr);
	}
	
	
	public static void quicksort(int[] intarr,int start,int end) {
		if(start<end) {
			int standard=intarr[start];		//�Ƚϵı�׼����
			int low=start;
			int high=end;
			while(low<high) {
				while(low<high&&intarr[high]>=standard) {
					high--;
				}
				intarr[low]=intarr[high];
				while(low<high&&intarr[low]<=standard) {
					low++;
				}
				intarr[high]=intarr[low];
			}
			intarr[low]=standard;
			quicksort(intarr, start, low);	//����С��һ��
			quicksort(intarr, low+1, end);	//������һ��
		}
		
	}
	
	
}
