package cn.wzx.algorithm;

import cn.wzx.tree.TreeNode;

/**
 * �����������С���
 * @author Administrator
 *
 */
public class TreeMinDeep {
	public static int run(TreeNode root) {
		if(root==null) {			//������ڵ�Ϊ�գ�ֱ�ӷ���0
			return 0;
		}
		if(root.leftNode==null&&root.rightNode==null) {	//������ڵ�����ҽڵ㶼Ϊ�գ�˵���ҵ�Ҷ�ӽڵ㣬����1
			return 1;
		}
		if(root.leftNode==null||root.rightNode==null) {	//������ڵ�����ҽڵ���һ��Ϊ�գ������ݹ�		
			return Math.max(run(root.leftNode), run(root.rightNode))+1;	//ȥ��Ϊ0����Чֵ��������max
		}		
		
		return  Math.min(run(root.leftNode), run(root.rightNode))+1;	//��������������������ݹ�
		
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.leftNode=new TreeNode(2);
		root.rightNode=new TreeNode(3);		//��С���Ϊ3
		root.leftNode.rightNode=new TreeNode(4);
		root.rightNode.rightNode=new TreeNode(4);
		System.out.println(run(root));
	}
	
	
}
