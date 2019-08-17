package cn.wzx.tree;
/**
 * ˳��洢������
 * ������ʵ��
 * @author Administrator
 *
 */
public class ArrayBinaryTree {
	int[] data;		//�洢����
	
	public static void main(String[] args) {
		int[] data=new int[]{1,2,3,4,5,6,7};
		ArrayBinaryTree tree=new ArrayBinaryTree(data);
		tree.frontShow();
		System.out.println("------------");
		tree.midShow();
		System.out.println("------------");
		tree.afterShow();
	}
	
	
	
	public ArrayBinaryTree(int[] data) {
		super();
		this.data = data;
	}



	/**
	 * ǰ�����
	 */
	public void frontShow(int index) {
		if(data!=null||data.length!=0) {
			System.out.println(data[index]);
			//�ж����ӽڵ��Ƿ����
			if(2*index+1<data.length) {
				frontShow(2*index+1);
			}
			//�ж����ӽڵ��Ƿ����
			if(2*index+2<data.length) {
				frontShow(2*index+2);
			}
		}
		
	}
	public void frontShow() {
		frontShow(0);
	}
	
	
	
	/**
	 * �������
	 */
	public void midShow(int index) {
		if(data!=null||data.length!=0) {
			//�ж����ӽڵ��Ƿ����
			if(2*index+1<data.length) {
				midShow(2*index+1);
			}
			System.out.println(data[index]);
			//�ж����ӽڵ��Ƿ����
			if(2*index+2<data.length) {
				midShow(2*index+2);
			}
		}
	}
	public void midShow() {
		midShow(0);
	}
	
	/**
	 * �������
	 */
	public void afterShow(int index) {
		if(data!=null||data.length!=0) {
			//�ж����ӽڵ��Ƿ����
			if(2*index+1<data.length) {
				afterShow(2*index+1);
			}
			//�ж����ӽڵ��Ƿ����
			if(2*index+2<data.length) {
				afterShow(2*index+2);
			}
			System.out.println(data[index]);
		}
	}
	public void afterShow() {
		afterShow(0);
	}
	
}
