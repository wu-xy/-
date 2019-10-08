package cn.wzx.sort;
/**
 * 归并排序
 * 使用递归
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
	 * @param intarr 排序数组
	 * @param low	 开始位置
	 * @param high	结束位置
	 */
	public static void merge(int[] intarr,int low,int high) {
		if(low<high) {
			int[] temp=new int[high-low+1];		//新建一个数组来排序
			int mid=(low+high)/2;				//取中间位置
			merge(intarr,low,mid);			//先分组再排序，如果数组还能分割就继续分割
			merge(intarr,mid+1,high);
			int index=0;
			int i = low,j=mid+1;			//分为两个数组，第一个数组从0开始，第二数组从中间位置+1开始
			while (i <= mid&&j<=high) {		//保证第一数组的结束位置为中间位置，第二个数组的结束位置为排序的结束位置
				if(intarr[i]<=intarr[j]) {
					temp[index]=intarr[i];
					i++;					//判断两个数组的数值大小，依次把 数值添加到新数组中
				}else {
					temp[index]=intarr[j];
					j++;
				}
				index++;
			}
			while(i <= mid) {		//左边数组比右边数组长的情况
				temp[index]=intarr[i];
				i++;
				index++;
			}
			while(j<=high) {		//右边数组比左边数组长的情况
				temp[index]=intarr[j];
				j++;
				index++;
			}
			for (int j2 = 0; j2 <temp.length; j2++) {	//将排好序的数组更新到元素组中
				intarr[j2+low]=temp[j2];
			}
		}
		
	}
	
	
}
