package cn.wzx.tree;
/**
 * 二叉排序树
 * 左节点<根节点<右节点
 * @author wzx
 *
 */
public class BinarySortTree {
	TreeNode rootNode;		//根节点
	
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
	 * 添加节点
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
	 * 删除子树
	 * 1.如果是叶子节点，直接删除
	 * 2.如果有有一个子节点，它的子节点代替它的位置
	 * 3.如果有两个子节点，右子树中最小的节点代替它的位置
	 * @param i
	 */
	public void deleteSort(int i) {
		if(rootNode==null) {
			return;
		}
		
		rootNode. deleteSort(i);					
	}
	
	/**
	 * 查找
	 */
	public TreeNode search(int i) {
		if(rootNode==null) {
			return null;
		}
		return rootNode.search(i);
	}
	/**
	 * 查找父节点
	 */
	public TreeNode searchParent(int i) {
		if(rootNode==null||rootNode.value==i) {		//如果根节点为空，或者查找的是根节点，返回null
			return null;
		}
		return rootNode.searchParent(i);
	}
	
	
	/**
	 * 前序查找
	 */
	public TreeNode frontSearch(int i) {
		return rootNode.frontSearch(i);
	}
	
	/**
	 * 中序查找
	 */
	public TreeNode midSearch(int i) {
		return rootNode.midSearch(i);
	}
	
	/**
	 * 后序查找
	 */
	public TreeNode afterSearch(int i) {
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
