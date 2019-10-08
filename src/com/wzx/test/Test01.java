package com.wzx.test;

import cn.wzx.sort.BubbleSort;

public class Test01 {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,8,53,11,23,4,6,7,10};
		heapSort(intarr);
		BubbleSort.arrToString(intarr);
	}
	
	/**
	 * 插入排序
	 * @param a
	 */
	public static void insertSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			if(a[i]<a[i-1]) {
				int temp=a[i];
				int j;
				for (j = i-1; j >=0&&temp<a[j]; j--) {
					a[j+1]=a[j];
				}
				a[j+1]=temp;
			}
		}
	}
	
	/**
	 * 选择排序
	 * @param a
	 */
	public static void selectSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int minIndex=i;			
			for (int j = i; j < a.length; j++) {
					if(a[j]<a[minIndex]) {
						minIndex=j;
					}
				}
			if(minIndex!=i) {
				int temp=a[i];
				a[i]=a[minIndex];
				a[minIndex]=temp;
			}
			
		}
	}
	
	/**
	 * 冒泡排序
	 * @param a
	 */
	public static void bubbleSort(int a[]) {
		for (int i = a.length-1; i > 0; i--) {		
			for (int j = 0; j < i; j++) {
					if(a[j]>a[j+1]) {
						int temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}						
		}
	}
	
	/**
	 * 快速排序
	 * @param a	排序数组
	 * @param start	开始位置
	 * @param end	结束位置
	 */
	public static void quickSort(int[] a,int start,int end) {
		if(start<end) {
			int standard=a[start];
			int low=start;
			int high=end;
			while(low<high) {
				while(low<high&&a[high]>=standard) {
					high--;
				}
				a[low]=a[high];
				while(low<high&&a[low]<=standard) {
					low++;
				}
				a[high]=a[low];
			}
			a[low]=standard;
			quickSort(a, start, low);
			quickSort(a, low+1, end);
		}
		
	}
	
	/**
	 * 希尔排序
	 * @param a
	 */
	public static void shellSort(int a[]) {
		for (int d = a.length/2; d > 0; d/=2) {
			for (int i = d; i < a.length; i++) {
				if(a[i]<a[i-d]) {
					int temp=a[i];
					int j;
					for (j = i-d; j >=0&&temp<a[j]; j-=d) {
						a[j+d]=a[j];
					}
					a[j+d]=temp;
				}
			}
		}
		
	}
	
	/**
	 * 归并排序
	 * @param a	排序数组
	 * @param start	开始位置
	 * @param end	结束位置
	 */
	public static void mergeSort(int[] a,int start,int end) {
		if(start<end) {
			int[] temp=new int[end-start+1];
			int mid=(end+start)/2;
			mergeSort(a, start, mid);
			mergeSort(a, mid+1, end);
			int low=start;
			int high=mid+1;
			int index=0;			
			while(low<=mid&&high<=end) {
				if(a[low]<a[high]) {
					temp[index]=a[low];
					low++;
				}else {
					temp[index]=a[high];
					high++;
				}
				index++;
			}
			while(low<=mid) {
				temp[index]=a[low];
				low++;
				index++;
			}
			while(high<=end) {
				temp[index]=a[high];
				high++;
				index++;
			}			
			for (int i = 0; i < temp.length; i++) {
				a[i+start]=temp[i];
			}
		}
		
	}
	
	/**
	 * 基数排序
	 * @param a
	 */
	public static void radixSort(int[] a) {
		int maxIndex=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]>a[maxIndex]) {
				maxIndex=i;
			}			
		}
		int max=a[maxIndex];
		int n=(max+"").length();
		int[][] temp=new int[10][a.length];
		int[] count=new int[10];
		for (int i = 0,k=1; i < n; i++,k=k*10) {
			for (int j = 0; j < a.length; j++) {
				int remd=(a[j]/k)%10;
				temp[remd][count[remd]]=a[j];
				count[remd]++;				
			}
			int index=0;
			for (int j = 0; j < 10; j++) {
				if(count[j]!=0) {
					for (int j2 = 0; j2 < count[j]; j2++) {
						a[index]=temp[j][j2];
						index++;
					}
					count[j]=0;
				}
			}
		}
	}
	
	/**
	 * 将数组变成大顶堆
	 * @param a
	 * @param index
	 * @param size
	 */
	public static void heap(int[] a,int index,int size) {
		int left=2*index+1;
		int right=2*index+2;
		if(left<size) {
			heap(a,left,size);
		}
		if(right<size) {
			heap(a,right,size);
		}
		int max=index;
		if(left<size&&a[left]>a[max]) {
			max=left;
		}
		if(right<size&&a[right]>a[max]) {
			max=right;
		}
		if(max!=index) {
			int temp=a[max];
			a[max]=a[index];
			a[index]=temp;
			heap(a,max,size);
		}
	}
	
	/**
	 * 堆排序
	 * @param a
	 */
	public static void heapSort(int a[]) {
		for (int size = a.length; size > 0; size--) {
			heap(a, 0, size);
			int temp=a[0];
			a[0]=a[size-1];
			a[size-1]=temp;
		}
	}
	
}
