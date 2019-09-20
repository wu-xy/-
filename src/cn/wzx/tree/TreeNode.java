package cn.wzx.tree;
/**
 * ���ڵ�
 * @author Administrator
 *
 */
public class TreeNode implements Comparable<TreeNode> {
	public int value;				//�ڵ��Ȩ��Я��������
	public TreeNode leftNode;		//���ӽڵ�
	public TreeNode rightNode;		//���ӽڵ�
	
	
	
	public TreeNode(int value) {
		super();
		this.value = value;
	}
	
	/**
	 * ��������Ҷ�ӽڵ�
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
	 * ǰ�����
	 * ��ǰ������
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
	 * �������
	 * �󣬵�ǰ����
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
	 * �������
	 * ���ң���ǰ
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
	 * ǰ�����
	 */
	public TreeNode frontSearch(int i) {
		TreeNode result=null;
		//���жϵ�ǰ�ڵ��Ƿ��ǲ���ֵ
		if(this.value==i) {
			return this;
		}else {
			//������ǣ����ж���ڵ��Ƿ��ǲ���ֵ
			if(leftNode!=null) {
				result=leftNode.frontSearch(i);
			}
			if(result!=null) {
				return result;
			}
			//������ж��ҽڵ��Ƿ��ǲ���ֵ
			if(rightNode!=null) {
				result=rightNode.frontSearch(i);
			}
			
		}
		return result;
		
	}
	
	/**
	 * �������
	 */
	public TreeNode midSearch(int i) {
		TreeNode result=null;
		//���ж���ڵ��Ƿ��ǲ���ֵ
		if(leftNode!=null) {
			result=leftNode.midSearch(i);
		}
		if(result!=null) {
			return result;
		}
		//������ǣ����жϵ�ǰ�ڵ��Ƿ��ǲ���ֵ
		if(this.value==i) {
			return this;
		}else {
			//������ж��ҽڵ��Ƿ��ǲ���ֵ
			if(rightNode!=null) {
				result=rightNode.midSearch(i);
			}
			
		}
		return result;
		
	}

	/**
	 * �������
	 * @param i
	 * @return
	 */
	public TreeNode afterSearch(int i) {
		TreeNode result=null;
		//���ж���ڵ��Ƿ��ǲ���ֵ
		if(leftNode!=null) {
			result=leftNode.midSearch(i);
			if(result!=null) {
				return result;
			}
		}
		//������ǣ����ж��ҽڵ��Ƿ��ǲ���ֵ
		if(rightNode!=null) {
			result=rightNode.midSearch(i);
			if(result!=null) {
				return result;
			}
		}
		//������жϵ�ǰ�ڵ��Ƿ��ǲ���ֵ
		if(this.value==i) {
			return this;
		}
		return result;
	}

	/**
	 * ɾ������
	 * @param i
	 */
	public void delete(int i) {
		TreeNode node=this;
		if(node.leftNode!=null) {			//�ж����ӽڵ��Ƿ�Ϊ��
			if(node.leftNode.value==i) {	//�ж����ӽڵ��ֵ�Ƿ�Ϊɾ��ֵ
				node.leftNode=null;
				return;
			}
			node.leftNode.delete(i);		//������Ǽ�������һ�����
		}
		if(node.rightNode!=null) {			//�ж����ӽڵ��Ƿ�Ϊ��
			if(node.rightNode.value==i) {	//�ж����ӽڵ��ֵ�Ƿ�Ϊɾ��ֵ
				node.rightNode=null;
				return;
			}
			node.rightNode.delete(i);		//������Ǽ�������һ�����
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
		//���жϵ�ǰ�ڵ��Ƿ��ǲ���ֵ
		if(this.value==i) {
			return this;
		}
		if(this.value>i) {		//�������ֵС�ڵ�ǰֵ���ʹ������в���			
			if(this.leftNode==null) {
				return null;
			}
			return this.leftNode.search(i);								
			
		}else {					//��֮���ʹ������в���	
			if(this.rightNode==null) {
				return null;
			}
			return this.rightNode.search(i);											
		}					
	}
	/**
	 * ���Ҹ��ڵ�
	 * @param i
	 * @return
	 */
	public TreeNode searchParent(int i) {
		//���жϵ�ǰ�ڵ������ӽڵ��Ƿ��ǲ���ֵ
		if((this.leftNode!=null&&this.leftNode.value==i)||(this.rightNode!=null&&this.rightNode.value==i)) {
			return this;
		}
		if(this.value>i) {		//�������ֵС�ڵ�ǰֵ���ʹ������в���			
			if(this.leftNode==null) {
				return null;
			}		
			return this.leftNode.searchParent(i);																
			
		}else {					//��֮���ʹ������в���	
			if(this.rightNode==null) {
				return null;
			}
			return this.rightNode.searchParent(i);											
		}					
	}
	
	/**
	 * ���������ɾ���ӽڵ�
	 * @param i
	 */
	public void deleteSort(int i) {
		TreeNode target = search(i); 		//���ҵ�Ҫɾ�����ӽڵ�
		TreeNode parent = searchParent(i);	//�ҵ�Ҫɾ���ڵ�ĸ��ڵ�
		if(target==null) {
			return;
		}
		if(target.leftNode==null&&target.rightNode==null) {		//�����Ҷ�ӽڵ�,ֱ��ɾ���ýڵ�
			if(parent.leftNode==target) {
				parent.leftNode=null;
			}else {
				parent.rightNode=null;
			}
		}else if(target.leftNode!=null&&target.rightNode!=null) {	//����������ӽڵ�
			int value=deleteMin(target.rightNode); 	//ɾ����������ֵ��С�Ľڵ�
			target.value=value;			//��Ŀ��ڵ��ֵ����Ϊ��С�ڵ��ֵ
						
		}else {			//�����һ���ӽڵ㣬�ӽڵ㶥��Ŀ��ڵ��λ��
						//���ж�Ŀ��ڵ��Ǹ��ڵ����ڵ㻹���ҽڵ�
						//���ж�Ŀ��ڵ���ӽڵ�����ڵ㻹���ҽڵ�	
			if(parent.leftNode==target) {		//Ŀ��ڵ��Ǹ��ڵ����ڵ����
				if(target.leftNode!=null) {		
					parent.leftNode=target.leftNode;//Ŀ��ڵ���ӽڵ�����ڵ����					
				}else {
					parent.leftNode=target.rightNode;//Ŀ��ڵ���ӽڵ����ҽڵ����
				}	
			}else {								//Ŀ��ڵ��Ǹ��ڵ���ҽڵ����
				if(target.leftNode!=null) {		
					parent.rightNode=target.leftNode;	//Ŀ��ڵ���ӽڵ�����ڵ����					
				}else {
					parent.rightNode=target.rightNode;	//Ŀ��ڵ���ӽڵ����ҽڵ����
				}
			}
		}
		
		
	}
	/**
	 * ɾ�������е���С�ڵ�
	 * ��С�ڵ�ֻ��ΪҶ�ӽڵ��һ���ҽڵ�
	 * @param rightNode
	 * @return
	 */
	public int deleteMin(TreeNode rightNode) {
		TreeNode node=rightNode;
		while(node.leftNode!=null) {
			node=node.leftNode;		//�ҵ���С�ӽڵ�
		}
		deleteSort(node.value);
		return node.value;
	}
	
	/**
	 * ���ص�ǰ���ĸ߶�
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
