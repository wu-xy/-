package cn.wzx.sort;
/**
 * 选择排序
 * @author Administrator
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,53,11,23,4,6,7,40};
		selectSort(intarr);
		BubbleSort.arrToString(intarr);
		
	}
	
	public static void selectSort(int[] intarr) {
		for (int i = 0; i < intarr.length; i++) {
			int minindex=i;
			for (int j = i+1; j < intarr.length; j++) {		//每次遍历找出剩下中最小的一个
				if (intarr[minindex]>intarr[j]) {
					minindex=j;
				}
			}
			if(minindex!=i) {
				int temp=intarr[minindex];
				intarr[minindex]=intarr[i];
				intarr[i]=temp;
			}
		}
	}
	
}
