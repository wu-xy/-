package com.wzx.search;

/**
 * 二分法查找
 * 只适用于有序数组
 * @author Administrator
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] a=new int[] {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(a, 10));
	}
	
	public static Object binarySearch(int[]a,int target) {
		int start=0;
		int end=a.length-1;
		int mid=end/2;
		while(start<=end) {
			if(a[mid]==target) {
				return a[mid];				
			}
			if(a[mid]>target) {
				end=mid-1;
			}
			if(a[mid]<target) {
				start=mid+1;
			}
			mid=(start+end)/2;
		}
		return null;

	}
	
}
