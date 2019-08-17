package cn.wzx.tree;
/**
 * 链式存储二叉树
 * 用链表实现
 * @author Administrator
 *
 */
public class BinaryTree {
	TreeNode rootNode;		//根节点
	
	public static void main(String[] args) {
		BinaryTree binTree=new BinaryTree();
		binTree.rootNode=new TreeNode(1);	//给根节点赋值
		TreeNode rootL1=new TreeNode(2);	
		TreeNode rootR1=new TreeNode(3);
		binTree.rootNode.leftNode=rootL1;	//给根节点的左子节点赋值
		binTree.rootNode.rightNode=rootR1;	//给根节点的右子节点赋值
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
	 * 删除子树
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
	 * 前序查找
	 */
	private TreeNode frontSearch(int i) {
		return rootNode.frontSearch(i);
	}
	
	/**
	 * 中序查找
	 */
	private TreeNode midSearch(int i) {
		return rootNode.midSearch(i);
	}
	
	/**
	 * 后序查找
	 */
	private TreeNode afterSearch(int i) {
		return rootNode.afterSearch(i);
	}
	
	/**
	 * 前序遍历
	 */
	public void frontShow() {
		if(rootNode!=null)
		rootNode.frontShow();
	}
	
	/**
	 * 中序遍历
	 */
	public void midShow() {
		if(rootNode!=null)
		rootNode.midShow();
	}
	
	/**
	 * 后序遍历
	 */
	public void afterShow() {
		if(rootNode!=null)
		rootNode.afterShow();
	}
	
}
