package cn.wzx.sort;
/**
 * 快速排序
 * 使用递归
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
			int standard=intarr[start];		//比较的标准数字
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
			quicksort(intarr, start, low);	//处理小的一边
			quicksort(intarr, low+1, end);	//处理大的一边
		}
		
	}
	
	
}
