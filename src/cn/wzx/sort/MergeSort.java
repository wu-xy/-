package cn.wzx.sort;
/**
 * 归并排序
 * 使用递归
 * @author Administrator
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,53,11,23,15,0,4,6,7,40};
		merge(intarr,0,intarr.length-1);
		BubbleSort.arrToString(intarr);
		
	}
	
	public static void merge(int[] intarr,int low,int high) {
		if(low<high) {
			int[] temp=new int[high-low+1];
			int mid=(low+high)/2;
			int index=0;
			int i = low,j=mid+1;
			merge(intarr,low,mid);			//先分组再排序
			merge(intarr,mid+1,high);
			while (i <= mid&&j<=high) {
				if(intarr[i]<=intarr[j]) {
					temp[index]=intarr[i];
					i++;
				}else {
					temp[index]=intarr[j];
					j++;
				}
				index++;
			}
			while(i <= mid) {
				temp[index]=intarr[i];
				i++;
				index++;
			}
			while(j<=high) {
				temp[index]=intarr[j];
				j++;
				index++;
			}
			for (int j2 = 0; j2 <temp.length; j2++) {
				intarr[j2+low]=temp[j2];
			}
		}
		
	}
	
	
}
