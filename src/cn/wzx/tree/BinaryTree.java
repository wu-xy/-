package cn.wzx.tree;
/**
 * ��ʽ�洢������
 * ������ʵ��
 * @author Administrator
 *
 */
public class BinaryTree {
	TreeNode rootNode;		//���ڵ�
	
	public static void main(String[] args) {
		BinaryTree binTree=new BinaryTree();
		binTree.rootNode=new TreeNode(1);	//�����ڵ㸳ֵ
		TreeNode rootL1=new TreeNode(2);	
		TreeNode rootR1=new TreeNode(3);
		binTree.rootNode.leftNode=rootL1;	//�����ڵ�����ӽڵ㸳ֵ
		binTree.rootNode.rightNode=rootR1;	//�����ڵ�����ӽڵ㸳ֵ
		rootL1.leftNode=new TreeNode(4);
		rootL1.rightNode=new TreeNode(5);
		rootR1.leftNode=new TreeNode(6);
		rootR1.rightNode=new TreeNode(7);
		binTree.frontShow();
		System.out.println("---------------");
		binTree.midShow();
		System.out.println("---------------");
		binTree.afterShow();
		System.out.println("---------------");
		TreeNode result=binTree.frontSearch(7);
		TreeNode result1=binTree.midSearch(6);
		TreeNode result2=binTree.afterSearch(5);
		System.out.println(result.value);
		System.out.println(result1.value);
		System.out.println(result2.value);
		binTree.delete(5);
		binTree.frontShow();
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
	 * ǰ�����
	 */
	private TreeNode frontSearch(int i) {
		return rootNode.frontSearch(i);
	}
	
	/**
	 * �������
	 */
	private TreeNode midSearch(int i) {
		return rootNode.midSearch(i);
	}
	
	/**
	 * �������
	 */
	private TreeNode afterSearch(int i) {
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
