package cn.wzx.tree;
/**
 * ƽ�������
 * ������������Ļ����ϸĽ�
 * ���������������߶Ⱥ��������߶�֮�����1
 * ��ڵ�<���ڵ�<�ҽڵ�
 * @author wzx
 *
 */
public class AVLTree {
	AVLTreeNode rootNode;		//���ڵ�
	
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
	 * ��ӽڵ�
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
	public AVLTreeNode search(int i) {
		if(rootNode==null) {
			return null;
		}
		return (AVLTreeNode) rootNode.search(i);
	}
	/**
	 * ���Ҹ��ڵ�
	 */
	public TreeNode searchParent(int i) {
		if(rootNode==null||rootNode.value==i) {		//������ڵ�Ϊ�գ����߲��ҵ��Ǹ��ڵ㣬����null
			return null;
		}
		return  rootNode.searchParent(i);
	}
	
	
	/**
	 * ǰ�����
	 */
	public AVLTreeNode frontSearch(int i) {
		return (AVLTreeNode) rootNode.frontSearch(i);
	}
	
	/**
	 * �������
	 */
	public AVLTreeNode midSearch(int i) {
		return (AVLTreeNode) rootNode.midSearch(i);
	}
	
	/**
	 * �������
	 */
	public AVLTreeNode afterSearch(int i) {
		return (AVLTreeNode) rootNode.afterSearch(i);
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

/**
 * ƽ��������ĸ��ڵ�
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
		if(leftHeight()-rightHeight()>1) {	//����ת
			if(leftNode!=null&&leftNode.leftHeight()<leftNode.rightHeight()) {
				((AVLTreeNode) leftNode).leftRotate();	//������ת
			}
			rightRotate();
		}
		if(rightHeight()-leftHeight()>1) {	//����ת
			if(rightNode!=null&&rightNode.rightHeight()<rightNode.leftHeight()) {
				((AVLTreeNode) leftNode).rightRotate();	//������ת
			}
			leftRotate();
		}
					
	}
	
	/**
	 * ����ת
	 */
	public void leftRotate() {
		TreeNode newLeft=new TreeNode(value);		//�½�һ���ڵ㣬ֵ�뵱ǰ�ڵ�ֵ���
		newLeft.leftNode=this.leftNode;				//�õ�ǰ�ڵ��������ָ���½��ڵ��������
		newLeft.rightNode=this.rightNode.leftNode;	//�õ�ǰ�ڵ����������������ָ���½��ڵ��������
		this.value=this.rightNode.value;			//�����ӽڵ��ֵ������ǰ�ڵ��ֵ
		this.rightNode=this.rightNode.rightNode;	//����ǰ�ڵ�����ӽڵ����Ϊ��ڵ��������
		this.leftNode=newLeft;						//����ǰ�ڵ�����ӽڵ����Ϊ�½��ڵ�
	}
	/**
	 * ����ת
	 */
	public void rightRotate() {
		TreeNode newRight=new TreeNode(value);		//�½�һ���ڵ㣬ֵ�뵱ǰ�ڵ�ֵ���
		newRight.rightNode=this.rightNode;			//�õ�ǰ�ڵ��������ָ���½��ڵ��������
		newRight.leftNode=this.leftNode.rightNode;	//�õ�ǰ�ڵ����������������ָ���½��ڵ��������
		this.value=this.leftNode.value;				//�����ӽڵ��ֵ������ǰ�ڵ��ֵ
		this.leftNode=this.leftNode.leftNode;		//����ǰ�ڵ�����ӽڵ����Ϊ��ڵ��������
		this.rightNode=newRight;					//����ǰ�ڵ�����ӽڵ����Ϊ�½��ڵ�
	}
		
}

