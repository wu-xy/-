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
			int low=start;		//左游标
			int high=end;		//右游标
			while(low<high) {
				while(low<high&&intarr[high]>=standard) {	//如果右游标指向的数值比标准值大，右游标向左移
					high--;
				}
				intarr[low]=intarr[high];	//此时右游标指向的数值比标准值小，将右游标的值赋给左游标，并开始移动左游标
				while(low<high&&intarr[low]<=standard) {	//如果左游标指向的数值比标准值小，左游标向右移
					low++;
				}
				intarr[high]=intarr[low];
			}
			intarr[low]=standard;	//此时左右游标重合
			quicksort(intarr, start, low);	//处理小的一边
			quicksort(intarr, low+1, end);	//处理大的一边
		}
		
	}
	
	
}
