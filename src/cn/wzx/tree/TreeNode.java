package cn.wzx.tree;
/**
 * 树节点
 * @author Administrator
 *
 */
public class TreeNode implements Comparable<TreeNode> {
	public int value;				//节点的权，携带的数据
	public TreeNode leftNode;		//左子节点
	public TreeNode rightNode;		//右子节点
	
	
	
	public TreeNode(int value) {
		super();
		this.value = value;
	}
	
	/**
	 * 有序的添加叶子节点
	 * @param node
	 */	
	public void add(TreeNode node) {
		if(node==null) {
			return;
		}
		if(this.value>node.value) {
			if(this.leftNode==null) {
				this.leftNode=node;				
			}else {
				this.leftNode.add(node);
			}
		}else {
			if(this.rightNode==null) {
				this.rightNode=node;				
			}else {
				this.rightNode.add(node);
			}
		}
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
	
	@Override
	public int compareTo(TreeNode o) {
		
		return this.value-o.value;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}

	public TreeNode search(int i) {
		//先判断当前节点是否是查找值
		if(this.value==i) {
			return this;
		}
		if(this.value>i) {		//如果查找值小于当前值，就从左树中查找			
			if(this.leftNode==null) {
				return null;
			}
			return this.leftNode.search(i);								
			
		}else {					//反之，就从右树中查找	
			if(this.rightNode==null) {
				return null;
			}
			return this.rightNode.search(i);											
		}					
	}
	/**
	 * 查找父节点
	 * @param i
	 * @return
	 */
	public TreeNode searchParent(int i) {
		//先判断当前节点左右子节点是否是查找值
		if((this.leftNode!=null&&this.leftNode.value==i)||(this.rightNode!=null&&this.rightNode.value==i)) {
			return this;
		}
		if(this.value>i) {		//如果查找值小于当前值，就从左树中查找			
			if(this.leftNode==null) {
				return null;
			}		
			return this.leftNode.searchParent(i);																
			
		}else {					//反之，就从右树中查找	
			if(this.rightNode==null) {
				return null;
			}
			return this.rightNode.searchParent(i);											
		}					
	}
	
	/**
	 * 有序二叉树删除子节点
	 * @param i
	 */
	public void deleteSort(int i) {
		TreeNode target = search(i); 		//先找到要删除的子节点
		TreeNode parent = searchParent(i);	//找到要删除节点的父节点
		if(target==null) {
			return;
		}
		if(target.leftNode==null&&target.rightNode==null) {		//如果是叶子节点,直接删除该节点
			if(parent.leftNode==target) {
				parent.leftNode=null;
			}else {
				parent.rightNode=null;
			}
		}else if(target.leftNode!=null&&target.rightNode!=null) {	//如果有两个子节点
			int value=deleteMin(target.rightNode); 	//删除右子树中值最小的节点
			target.value=value;			//将目标节点的值更改为最小节点的值
						
		}else {			//如果有一个子节点，子节点顶替目标节点的位置
						//先判断目标节点是父节点的左节点还是右节点
						//再判断目标节点的子节点是左节点还是右节点	
			if(parent.leftNode==target) {		//目标节点是父节点的左节点情况
				if(target.leftNode!=null) {		
					parent.leftNode=target.leftNode;//目标节点的子节点是左节点情况					
				}else {
					parent.leftNode=target.rightNode;//目标节点的子节点是右节点情况
				}	
			}else {								//目标节点是父节点的右节点情况
				if(target.leftNode!=null) {		
					parent.rightNode=target.leftNode;	//目标节点的子节点是左节点情况					
				}else {
					parent.rightNode=target.rightNode;	//目标节点的子节点是右节点情况
				}
			}
		}
		
		
	}
	/**
	 * 删除子树中的最小节点
	 * 最小节点只能为叶子节点或一个右节点
	 * @param rightNode
	 * @return
	 */
	public int deleteMin(TreeNode rightNode) {
		TreeNode node=rightNode;
		while(node.leftNode!=null) {
			node=node.leftNode;		//找到最小子节点
		}
		deleteSort(node.value);
		return node.value;
	}
	
	/**
	 * 返回当前树的高度
	 * @return
	 */
	public int height() {
		return Math.max(leftNode==null?0:leftNode.height(), rightNode==null?0:rightNode.height())+1;

	}
	public int leftHeight() {
		if(leftNode==null) {
			return 0;
		}
		return  leftNode.height();

	}
	public int rightHeight() {
		if(rightNode==null) {
			return 0;
		}
		return  rightNode.height();
		

	}
	
}
