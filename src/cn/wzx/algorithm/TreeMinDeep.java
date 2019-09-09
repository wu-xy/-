package cn.wzx.algorithm;

import cn.wzx.tree.TreeNode;

/**
 * 求二叉树的最小深度
 * @author Administrator
 *
 */
public class TreeMinDeep {
	public static int run(TreeNode root) {
		if(root==null) {			//如果根节点为空，直接返回0
			return 0;
		}
		if(root.leftNode==null&&root.rightNode==null) {	//如果根节点的左右节点都为空，说明找到叶子节点，返回1
			return 1;
		}
		if(root.leftNode==null||root.rightNode==null) {	//如果根节点的左右节点有一个为空，继续递归		
			return Math.max(run(root.leftNode), run(root.rightNode))+1;	//去掉为0的无效值，所以用max
		}		
		
		return  Math.min(run(root.leftNode), run(root.rightNode))+1;	//不满足上述情况，继续递归
		
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.leftNode=new TreeNode(2);
		root.rightNode=new TreeNode(3);		//最小深度为3
		root.leftNode.rightNode=new TreeNode(4);
		root.rightNode.rightNode=new TreeNode(4);
		System.out.println(run(root));
	}
	
	
}
