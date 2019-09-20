import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		TreeNode root1=new TreeNode(8);
		root1.left=new TreeNode(6);
		root1.right=new TreeNode(10);
		root1.left.left=new TreeNode(5);
		root1.left.right=new TreeNode(7);
		root1.right.left=new TreeNode(9);
		root1.right.right=new TreeNode(11);
		
		TreeNode root=new TreeNode(root1.val);
		Solution solution = new Solution();
		solution.sort1(root1, root);
		root1=root;
		solution.sort(root1);
	}
	
    public void sort1(TreeNode root,TreeNode root1){
    	root1.val =root.val ;
        if(root.right!=null){
        	root1.left=new TreeNode(0);
            sort1(root.right,root1.left);
        }
        if(root.left!=null){
        	root1.right=new TreeNode(0);
            sort1(root.left,root1.right);
        }
    }
    public void sort(TreeNode root){
    	System.out.println(root.val);;
        if(root.right!=null){
            sort(root.left);
        }
        if(root.left!=null){
            sort(root.right);
        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}