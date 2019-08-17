package cn.wzx.tree;
/**
 * ����������
 * ����ʽ�洢�������Ļ�����ʵ��
 * ������ʵ��
 * @author Administrator
 *
 */
public class ThreadBinaryTree {
	ThreadTreeNode rootNode;		//���ڵ�
	ThreadTreeNode pre=null;				//��һ���ڵ�
	
	public static void main(String[] args) {
		ThreadBinaryTree binTree=new ThreadBinaryTree();
		binTree.rootNode=new ThreadTreeNode(1);	//�����ڵ㸳ֵ
		ThreadTreeNode rootL1=new ThreadTreeNode(2);	
		ThreadTreeNode rootR1=new ThreadTreeNode(3);
		binTree.rootNode.leftNode=rootL1;	//�����ڵ�����ӽڵ㸳ֵ
		binTree.rootNode.rightNode=rootR1;	//�����ڵ�����ӽڵ㸳ֵ
		rootL1.leftNode=new ThreadTreeNode(4);
		rootL1.rightNode=new ThreadTreeNode(5);
		rootR1.leftNode=new ThreadTreeNode(6);
		rootR1.rightNode=new ThreadTreeNode(7);
		binTree.frontShow();
		System.out.println("---------------");
		binTree.midShow();
		System.out.println("---------------");
		binTree.afterShow();
		System.out.println("---------------");
		ThreadTreeNode result=binTree.frontSearch(7);
		ThreadTreeNode result1=binTree.midSearch(6);
		System.out.println(result.value);
		System.out.println(result1.value);
		binTree.delete(7);
		binTree.frontShow();
		System.out.println("---------------");
		binTree.midThread();
		binTree.threadIterate();
		
	}
	
	/**
	 * ɾ������
	 * @param i
	 */
	private void delete(int i) {
		if(rootNode.value==i) {
			rootNode=null;
		}else {
			rootNode.delete(i);
		}
			
	}
	
	/**
	 * �����������ı���
	 */
	public void threadIterate() {
		ThreadTreeNode temp=rootNode;
		while(temp!=null) {
			//�ҵ�����ߵĵ�һ��Ԫ�أ�ֻ����ָ��û�й�ϵ�����Ľڵ�Ż�ִ��
			//��ֹ��ǰ�ظ���ȡ
			while(temp.leftType==0) {
				temp=temp.leftNode;
			}
			System.out.println(temp.value);
			while(temp.ringhtType==1) {			//�ж���ָ���Ƿ����������ϵ
				temp=temp.rightNode;
				System.out.println(temp.value);
			}
			temp=temp.rightNode;
			
		}
	}
	
	
	
	
	/**
	 * ��������������
	 */
	public void midThread(ThreadTreeNode node) {
		if(node.leftNode!=null) {
			midThread(node.leftNode);
		}
		if(node.leftNode==null) {		//�����ǰ�ڵ����ָ��Ϊ�գ���ָ����һ���ڵ�
			node.leftNode=pre;
			node.leftType=1;
		}
		if(pre!=null&&pre.rightNode==null) {	//�����һ���ڵ����ָ��Ϊ�գ���ָ��ǰ�ڵ�
			pre.rightNode=node;
			pre.ringhtType=1;
		}
		pre=node;
		if(node.rightNode!=null) {
			midThread(node.rightNode);
		}
	}
	
	
	public void midThread() {
		midThread(rootNode);
	}
	

	/**
	 * ǰ�����
	 */
	private ThreadTreeNode frontSearch(int i) {
		return rootNode.frontSearch(i);
	}
	
	/**
	 * �������
	 */
	private ThreadTreeNode midSearch(int i) {
		return rootNode.midSearch(i);
	}
	
	/**
	 * �������
	 */
	private ThreadTreeNode afterSearch(int i) {
		return rootNode.afterSearch(i);
	}
	
	/**
	 * ǰ�����
	 */
	public void frontShow() {
		if(rootNode!=null)
		rootNode.frontShow();
	}
	
	/**
	 * �������
	 */
	public void midShow() {
		if(rootNode!=null)
		rootNode.midShow();
	}
	
	/**
	 * �������
	 */
	public void afterShow() {
		if(rootNode!=null)
		rootNode.afterShow();
	}
	
}
