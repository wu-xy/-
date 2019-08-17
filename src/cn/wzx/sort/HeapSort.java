package cn.wzx.sort;
/**
 * 堆排序
 * 用顺序二叉树来实现
 * @author Administrator
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] data=new int[] {8,1,9,7,8,593,53,11,23,156,308,15,0,4,6,7,40,36,106};
		heapSort(data);
		BubbleSort.arrToString(data);
	}
	
	
	public static void heapSort(int[]data) {
		int size=data.length;
		for(int i=size;i>0;i--) {
			heap(data, i, 0);
			int temp=data[0];
			data[0]=data[i-1];
			data[i-1]=temp;
		}
	}
	
	/**
	 * 将数组调整为大堆
	 * @param data	排序数组
	 * @param size	排序范围
	 * @param index	开始排序的位置
	 */
	public static void heap(int[]data,int size,int index) {
		if(data!=null) {
			int leftNode=2*index+1;		//左子节点
			int righttNode=2*index+2;	//右子节点
			//判断左孙节点是否存在
			if(4*index+3<size) {
				heap(data,size,leftNode);
			}
			//判断右孙节点是否存在
			if(4*index+4<size) {
				heap(data,size,righttNode);
			}
			int max=index;
			if(leftNode<size&&data[leftNode]>data[max]) {		//判断左子节点是否较大
				max=leftNode;
			}
			if(righttNode<size&&data[righttNode]>data[max]) {	//判断右子节点是否较大
				max=righttNode;
			}
			if(max!=index) {			//如果最大值已变
				int temp=data[index];
				data[index]=data[max];
				data[max]=temp;
				heap(data,size,max);
			}
			
		}
	}
	
	
	
}
