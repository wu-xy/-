package cn.wzx.sort;
/**
 * 希尔排序
 * 在插入排序的基础上，优化
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
		for (int d = intarr.length/2; d > 0; d=d/2) {	//对数组进行分组，控制分组次数
			for (int i = d; i < intarr.length; i++) {	//对已分好的组进行插入排序
				if(intarr[i]<intarr[i-d]) {				//如果后面的数比前面的小，将它移到前面去
					int temp=intarr[i];
					int j;
					for ( j = i-d; j >=0&&temp<intarr[j]; j-=d) {
						intarr[j+d]=intarr[j];	//将数据往后移
					}
					intarr[j+d]=temp;			//最终插入的位置
				}
			}
		}
	}
	
	public static void shelltsort1(int[] intarr) {
		for (int d = intarr.length/2; d > 0; d=d/2) {	//对数组进行分组，控制分组次数
			for (int i = d; i < intarr.length; i++) {	//对已分好的组进行插入排序
				//如果后面的数比前面的小，将它移到前面去
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
