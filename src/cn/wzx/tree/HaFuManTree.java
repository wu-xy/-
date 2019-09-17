package cn.wzx.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ´´½¨Ò»¿Å¹þ·òÂüÊ÷
 * @author wzx
 *
 */
public class HaFuManTree {
	public static void main(String[] args) {
		int[] array=new int[]{3,5,7,8,23,29,11,14};
		 TreeNode node = haFuMan(array);
		 node.frontShow();
		 
	}
	public static TreeNode haFuMan(int[] array) {
		List<TreeNode> list=new ArrayList<TreeNode>();
		for (int val : array) {
			list.add(new TreeNode(val));
		}
		while(list.size()>1) {
			list.sort(null);
			 TreeNode node1=list.get(0);
			 TreeNode node2=list.get(1);
			 TreeNode node=new TreeNode(node1.value+node2.value);
			 node.leftNode=node1;
			 node.rightNode=node2;
			 list.remove(1);
			 list.remove(0);
			 list.add(node);			 			
		}				
		return list.get(0);
		

	}
}
