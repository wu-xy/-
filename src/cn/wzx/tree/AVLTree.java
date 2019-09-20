package cn.wzx.tree;
/**
 * 平衡二叉树
 * 在排序二叉树的基础上改进
 * 任意树的左子树高度和右子树高度之差不超过1
 * 左节点<根节点<右节点
 * @author wzx
 *
 */
public class AVLTree {
	AVLTreeNode rootNode;		//根节点
	
	public static void main(String[] args) {
		AVLTree binTree=new AVLTree();
		int[] array=new int[] {8,9,6,7,5,4,10,11,12};
		//int[] array=new int[] {2,1,4,3,5,6};
		for (int i : array) {
			binTree.add(new AVLTreeNode(i));
		}
		binTree.midShow();
		System.out.println("----------");		
		System.out.println(binTree.searchParent(10));
		System.out.println("----------");
		System.out.println(binTree.height());
		System.out.println(binTree.rootNode.leftHeight());
		System.out.println(binTree.rootNode.rightHeight());
		System.out.println(binTree.rootNode);
		
	}
	
	public int height() {
		if(rootNode==null) {
			return 0;
		}
		return rootNode.height();
	}

	/**
	 * 添加节点
	 * @param node
	 */
	public void add(AVLTreeNode node) {
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
	public AVLTreeNode search(int i) {
		if(rootNode==null) {
			return null;
		}
		return (AVLTreeNode) rootNode.search(i);
	}
	/**
	 * 查找父节点
	 */
	public TreeNode searchParent(int i) {
		if(rootNode==null||rootNode.value==i) {		//如果根节点为空，或者查找的是根节点，返回null
			return null;
		}
		return  rootNode.searchParent(i);
	}
	
	
	/**
	 * 前序查找
	 */
	public AVLTreeNode frontSearch(int i) {
		return (AVLTreeNode) rootNode.frontSearch(i);
	}
	
	/**
	 * 中序查找
	 */
	public AVLTreeNode midSearch(int i) {
		return (AVLTreeNode) rootNode.midSearch(i);
	}
	
	/**
	 * 后序查找
	 */
	public AVLTreeNode afterSearch(int i) {
		return (AVLTreeNode) rootNode.afterSearch(i);
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

/**
 * 平衡二叉树的根节点
 * @author Administrator
 *
 */
class AVLTreeNode extends TreeNode {
	
	public AVLTreeNode(int value) {
		super(value);
	}
	@Override
	public void add(TreeNode node) {
		super.add(node);
		if(leftHeight()-rightHeight()>1) {	//右旋转
			if(leftNode!=null&&leftNode.leftHeight()<leftNode.rightHeight()) {
				((AVLTreeNode) leftNode).leftRotate();	//先左旋转
			}
			rightRotate();
		}
		if(rightHeight()-leftHeight()>1) {	//左旋转
			if(rightNode!=null&&rightNode.rightHeight()<rightNode.leftHeight()) {
				((AVLTreeNode) leftNode).rightRotate();	//先右旋转
			}
			leftRotate();
		}
					
	}
	
	/**
	 * 左旋转
	 */
	public void leftRotate() {
		TreeNode newLeft=new TreeNode(value);		//新建一个节点，值与当前节点值相等
		newLeft.leftNode=this.leftNode;				//让当前节点的左子树指向新建节点的左子树
		newLeft.rightNode=this.rightNode.leftNode;	//让当前节点的右子树的左子树指向新建节点的右子树
		this.value=this.rightNode.value;			//将右子节点的值赋给当前节点的值
		this.rightNode=this.rightNode.rightNode;	//将当前节点的左子节点更改为左节点的左子树
		this.leftNode=newLeft;						//将当前节点的左子节点更改为新建节点
	}
	/**
	 * 右旋转
	 */
	public void rightRotate() {
		TreeNode newRight=new TreeNode(value);		//新建一个节点，值与当前节点值相等
		newRight.rightNode=this.rightNode;			//让当前节点的右子树指向新建节点的右子树
		newRight.leftNode=this.leftNode.rightNode;	//让当前节点的左子树的右子树指向新建节点的左子树
		this.value=this.leftNode.value;				//将左子节点的值赋给当前节点的值
		this.leftNode=this.leftNode.leftNode;		//将当前节点的左子节点更改为左节点的左子树
		this.rightNode=newRight;					//将当前节点的右子节点更改为新建节点
	}
		
}

