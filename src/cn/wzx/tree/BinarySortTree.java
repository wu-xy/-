package cn.wzx.tree;
/**
 * ����������
 * ��ڵ�<���ڵ�<�ҽڵ�
 * @author wzx
 *
 */
public class BinarySortTree {
	TreeNode rootNode;		//���ڵ�
	
	public static void main(String[] args) {
		BinarySortTree binTree=new BinarySortTree();
		int[] array=new int[] {7,3,10,12,5,1,9,13};
		for (int i : array) {
			binTree.add(new TreeNode(i));
		}
		binTree.midShow();
		System.out.println("----------");		
		System.out.println(binTree.searchParent(5));
		System.out.println("----------");
		binTree.deleteSort(7);
		binTree.midShow();		
	}
	
	/**
	 * ��ӽڵ�
	 * @param node
	 */
	public void add(TreeNode node) {
		if(node==null) {
			return;
		}
		if(rootNode==null) {
			rootNode=node;
		}else {
			rootNode.add(node);
		}				
	}
		
	
	/**
	 * ɾ������
	 * 1.�����Ҷ�ӽڵ㣬ֱ��ɾ��
	 * 2.�������һ���ӽڵ㣬�����ӽڵ��������λ��
	 * 3.����������ӽڵ㣬����������С�Ľڵ��������λ��
	 * @param i
	 */
	public void deleteSort(int i) {
		if(rootNode==null) {
			return;
		}
		
		rootNode. deleteSort(i);					
	}
	
	/**
	 * ����
	 */
	public TreeNode search(int i) {
		if(rootNode==null) {
			return null;
		}
		return rootNode.search(i);
	}
	/**
	 * ���Ҹ��ڵ�
	 */
	public TreeNode searchParent(int i) {
		if(rootNode==null||rootNode.value==i) {		//������ڵ�Ϊ�գ����߲��ҵ��Ǹ��ڵ㣬����null
			return null;
		}
		return rootNode.searchParent(i);
	}
	
	
	/**
	 * ǰ�����
	 */
	public TreeNode frontSearch(int i) {
		return rootNode.frontSearch(i);
	}
	
	/**
	 * �������
	 */
	public TreeNode midSearch(int i) {
		return rootNode.midSearch(i);
	}
	
	/**
	 * �������
	 */
	public TreeNode afterSearch(int i) {
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
