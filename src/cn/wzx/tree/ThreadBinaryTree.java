package cn.wzx.tree;
/**
 * 线索二叉树
 * 在链式存储二叉树的基础上实现
 * 用链表实现
 * @author Administrator
 *
 */
public class ThreadBinaryTree {
	ThreadTreeNode rootNode;		//根节点
	ThreadTreeNode pre=null;				//上一个节点
	
	public static void main(String[] args) {
		ThreadBinaryTree binTree=new ThreadBinaryTree();
		binTree.rootNode=new ThreadTreeNode(1);	//给根节点赋值
		ThreadTreeNode rootL1=new ThreadTreeNode(2);	
		ThreadTreeNode rootR1=new ThreadTreeNode(3);
		binTree.rootNode.leftNode=rootL1;	//给根节点的左子节点赋值
		binTree.rootNode.rightNode=rootR1;	//给根节点的右子节点赋值
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
	 * 线索二叉树的遍历
	 */
	public void threadIterate() {
		ThreadTreeNode temp=rootNode;
		while(temp!=null) {
			//找到最左边的第一个元素，只有左指针没有关系线索的节点才会执行
			//防止向前重复读取
			while(temp.leftType==0) {
				temp=temp.leftNode;
			}
			System.out.println(temp.value);
			while(temp.ringhtType==1) {			//判断右指针是否存在线索关系
				temp=temp.rightNode;
				System.out.println(temp.value);
			}
			temp=temp.rightNode;
			
		}
	}
	
	
	
	
	/**
	 * 中序化线索二叉树
	 */
	public void midThread(ThreadTreeNode node) {
		if(node.leftNode!=null) {
			midThread(node.leftNode);
		}
		if(node.leftNode==null) {		//如果当前节点的左指针为空，则指向上一个节点
			node.leftNode=pre;
			node.leftType=1;
		}
		if(pre!=null&&pre.rightNode==null) {	//如果上一个节点的右指针为空，则指向当前节点
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
	 * 前序查找
	 */
	private ThreadTreeNode frontSearch(int i) {
		return rootNode.frontSearch(i);
	}
	
	/**
	 * 中序查找
	 */
	private ThreadTreeNode midSearch(int i) {
		return rootNode.midSearch(i);
	}
	
	/**
	 * 后序查找
	 */
	private ThreadTreeNode afterSearch(int i) {
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
