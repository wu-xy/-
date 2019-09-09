package cn.wzx.algorithm;

import cn.wzx.tree.TreeNode;

/**
 * �ؽ�������
 * @author Administrator
 *
 */
public class RebuildTreeNode {
	 public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 
		return rebuild(pre, 0, pre.length-1, in, 0, in.length-1);		 
	 }
	 public static TreeNode rebuild(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
		 if(startPre>endPre||startIn>endIn) {
			 return null;
		 }
		 TreeNode root=new TreeNode(pre[startPre]);	//���ڵ�Ϊǰ������ĵ�һ��Ԫ��
		 for (int i = startIn; i <= endIn; i++) {
			if(pre[startPre]==in[i]) {		//�ҵ���������и��ڵ��λ��
				//���ݸ��ڵ�����������е�λ�ã��ó����ڵ����������ĸ���
				//Ȼ�����������и��Ϊ������ǰ�б�����������ǰ�б���
				root.leftNode=rebuild(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
				root.rightNode=rebuild(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
			}
		}
		 		 
		return root;
		 
	 }
	 public static void main(String[] args) {
		int[] pre= {1,2,4,7,3,5,6,8};
		int [] in={4,7,2,1,5,3,8,6};
//		int[] pre1= {1,2,4,5,3,6,7};
//		int [] in1={4,2,5,1,6,3,7};
		TreeNode root = reConstructBinaryTree(pre, in);
		root.frontShow();
		System.out.println("-----------");
		root.midShow();
	}
	 
	 
}
