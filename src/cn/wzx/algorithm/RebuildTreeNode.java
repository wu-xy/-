package cn.wzx.algorithm;

import cn.wzx.tree.TreeNode;

/**
 * 重建二叉树
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
		 TreeNode root=new TreeNode(pre[startPre]);	//根节点为前序遍历的第一个元素
		 for (int i = startIn; i <= endIn; i++) {
			if(pre[startPre]==in[i]) {		//找到中序遍历中根节点的位置
				//根据根节点在中序遍历中的位置，得出根节点左右子树的个数
				//然后对数组进行切割，分为左树的前中遍历和右树的前中遍历
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
