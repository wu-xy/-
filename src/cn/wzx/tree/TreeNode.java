package cn.wzx.tree;
/**
 * 树节点
 * @author Administrator
 *
 */
public class TreeNode {
	public int value;				//节点的权，携带的数据
	public TreeNode leftNode;		//左子节点
	public TreeNode rightNode;		//右子节点
	
	
	
	public TreeNode(int value) {
		super();
		this.value = value;
	}

	/**
	 * 前序遍历
	 * 当前，左，右
	 */
	public void frontShow() {
		System.out.println(value);
		if(leftNode!=null) {
			leftNode.frontShow();
		}
		if(rightNode!=null) {
			rightNode.frontShow();
		}
	}
	
	/**
	 * 中序遍历
	 * 左，当前，右
	 */
	public void midShow() {
		if(leftNode!=null) {
			leftNode.midShow();
		}
		System.out.println(value);
		if(rightNode!=null) {
			rightNode.midShow();
		}
	}
	
	/**
	 * 后序遍历
	 * 左，右，当前
	 */
	public void afterShow() {
		if(leftNode!=null) {
			leftNode.afterShow();
		}
		if(rightNode!=null) {
			rightNode.afterShow();
		}
		System.out.println(value);
	}
	
	/**
	 * 前序查找
	 */
	public TreeNode frontSearch(int i) {
		TreeNode result=null;
		//先判断当前节点是否是查找值
		if(this.value==i) {
			return this;
		}else {
			//如果不是，再判断左节点是否是查找值
			if(leftNode!=null) {
				result=leftNode.frontSearch(i);
			}
			if(result!=null) {
				return result;
			}
			//最后再判断右节点是否是查找值
			if(rightNode!=null) {
				result=rightNode.frontSearch(i);
			}
			
		}
		return result;
		
	}
	
	/**
	 * 中序查找
	 */
	public TreeNode midSearch(int i) {
		TreeNode result=null;
		//先判断左节点是否是查找值
		if(leftNode!=null) {
			result=leftNode.midSearch(i);
		}
		if(result!=null) {
			return result;
		}
		//如果不是，再判断当前节点是否是查找值
		if(this.value==i) {
			return this;
		}else {
			//最后再判断右节点是否是查找值
			if(rightNode!=null) {
				result=rightNode.midSearch(i);
			}
			
		}
		return result;
		
	}

	/**
	 * 后序查找
	 * @param i
	 * @return
	 */
	public TreeNode afterSearch(int i) {
		TreeNode result=null;
		//先判断左节点是否是查找值
		if(leftNode!=null) {
			result=leftNode.midSearch(i);
			if(result!=null) {
				return result;
			}
		}
		//如果不是，再判断右节点是否是查找值
		if(rightNode!=null) {
			result=rightNode.midSearch(i);
			if(result!=null) {
				return result;
			}
		}
		//最后再判断当前节点是否是查找值
		if(this.value==i) {
			return this;
		}
		return result;
	}

	/**
	 * 删除子树
	 * @param i
	 */
	public void delete(int i) {
		TreeNode node=this;
		if(node.leftNode!=null) {			//判断左子节点是否为空
			if(node.leftNode.value==i) {	//判断左子节点的值是否为删除值
				node.leftNode=null;
				return;
			}
			node.leftNode.delete(i);		//如果不是继续向下一层查找
		}
		if(node.rightNode!=null) {			//判断右子节点是否为空
			if(node.rightNode.value==i) {	//判断右子节点的值是否为删除值
				node.rightNode=null;
				return;
			}
			node.rightNode.delete(i);		//如果不是继续向下一层查找
		}
		
	}
	
}
