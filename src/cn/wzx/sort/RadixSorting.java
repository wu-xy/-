package cn.wzx.sort;
/**
 * 基数排序
 * 创建10个数组0,1,2,3,4，5,6,7,8,9
 * 第一次把个位相同的放到同一个数组
 * 第二次把十位相同的放到同一个数组
 * 依次类推
 * @author Administrator
 *
 */
public class RadixSorting {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,593,53,11,23,156,308,15,0,4,6,7,40,36,106};
		radixSorting1(intarr);
		BubbleSort.arrToString(intarr);
		
	}
	
	public static void radixSorting(int[] intarr) {		//用二维数组来实现
		int max=0;		//取出数组中最大的数
		for (int i = 0; i < intarr.length; i++) {
			if(intarr[i]>max) {
				max=intarr[i];
			}
		}
		int n=(max+"").length();	//计算需要比较的次数
		int[][] temp=new int[10][intarr.length];	//创建一个二维数组 10*排序数组长度
		int[] count=new int[10];			//记录每个数组的长度
		for (int i = 0,k=1; i < n; i++,k=k*10) {
			
			for (int j = 0; j < intarr.length; j++) {
				int remd=(intarr[j]/k)%10;			//计算个位、十位或者百位上的数字
				temp[remd][count[remd]]=intarr[j];
				count[remd]++;
			}
			int index=0;
			for (int l = 0; l < 10; l++) {
				if(count[l]!=0) {
					for (int j = 0; j < count[l]; j++) {
						intarr[index]=temp[l][j];	//将元素放回原来的数组
						index++;		
					}
					count[l]=0; 	//取出元素后，将记录数组重置为0
				}
			}
			
			
		}
		
			
		
	}
	public static void radixSorting1(int[] intarr) { 	//用队列来实现
		int max=0;		//取出数组中最大的数
		for (int i = 0; i < intarr.length; i++) {
			if(intarr[i]>max) {
				max=intarr[i];
			}
		}
		int n=(max+"").length();	//计算需要比较的次数
		Queue[] queue=new Queue[10];	//创建1个队列数组
		for (int i = 0; i < queue.length; i++) {
			queue[i]=new Queue();
		}
		for (int i = 0,k=1; i < n; i++,k=k*10) {
			
			for (int j = 0; j < intarr.length; j++) {
				int remd=(intarr[j]/k)%10;			//计算个位、十位或者百位上的数字
				queue[remd].add(intarr[j]);
			}
			int index=0;
			for (int j = 0; j < queue.length; j++) {
				while(!queue[j].isEmpty()) {
					intarr[index]=queue[j].pull();
					index++;
				}
			}
			
		}
					
	}
	
}
/**
 * 队列
 * 先进先出
 * 加入拍到最后
 * @author Administrator
 *
 */
class Queue{
	int[] temp;
	int length;

	public Queue() {
		this.length=0;
		this.temp = new int[length];
	}
	
	public boolean isEmpty() {
		if(temp.length==0) {
			return true;
		}
		
		return false;
	}
	public void add(int element) {
		length++;
		int[] intarr=new int[length];
		for (int i = 0; i < temp.length; i++) {
			intarr[i]=temp[i];
		}
		intarr[length-1]=element;
		temp=intarr;
	}
	public int pull(){
		int inttemp=temp[0];
		length--;
		int[] intarr=new int[length];
		for (int i = 1; i < temp.length; i++) {
			intarr[i-1]=temp[i];
		}
		temp=intarr;
		return inttemp;
		
	}
	
	
}




