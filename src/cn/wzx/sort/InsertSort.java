package cn.wzx.sort;
/**
 * 插入排序
 * @author Administrator
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,53,11,23,4,6,7};
		insertsort(intarr);
		BubbleSort.arrToString(intarr);
		
	}
	
	public static void insertsort(int[] intarr) {
		for (int i = 1; i < intarr.length; i++) {
			if (intarr[i]<intarr[i-1]) {
				int temp=intarr[i];
				int j;
				for ( j = i-1; j >= 0&&temp<intarr[j]; j--) {
					intarr[j+1]=intarr[j];	//将数据往后移
				}
				intarr[j+1]=temp;
			}
		}
	}
	
}
