package cn.wzx.tree;
/**
 * ���ڵ�
 * @author Administrator
 *
 */
public class TreeNode {
	public int value;				//�ڵ��Ȩ��Я��������
	public TreeNode leftNode;		//���ӽڵ�
	public TreeNode rightNode;		//���ӽڵ�
	
	
	
	public TreeNode(int value) {
		super();
		this.value = value;
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
	
}
