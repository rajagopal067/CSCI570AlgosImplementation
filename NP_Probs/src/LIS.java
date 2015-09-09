
public class LIS {

	public static int getLIS(TreeNode node){
		
		if(node == null)
			return 0;
		
		if(node.getLSS() != 0)
			return node.getLSS();
		
		if(node.getLeft() == null && node.getRight() == null){
			node.setLSS(1);
			return 1;
		}
		
		int lis_excl = getLIS(node.getLeft()) + getLIS(node.getRight());
		int lis_incl = 1;
		if(node.getLeft()!=null){
			lis_incl += getLIS(node.getLeft().getLeft()) + getLIS(node.getLeft().getRight());
		}
		if(node.getRight() != null){
			lis_incl += getLIS(node.getRight().getLeft()) + getLIS(node.getRight().getRight());
		}
		node.setLSS(Math.max(lis_incl, lis_excl));
		return node.getLSS();
	}
	
	
	public static void printLIS(TreeNode node){
		if(node == null){
			return;
		}
		TreeNode left = node.getLeft();
		TreeNode right = node.getRight();
		// root is excluded
		if(left != null && right != null &&  node.getLSS() == left.getLSS() + right.getLSS()){
			System.out.print(left.getValue() + "\t" + right.getValue() + "\t");
			printLIS(node.getLeft());
			printLIS(node.getRight());
		}
		
		// root is included
		else{
			System.out.print(node.getValue() + "\t");
			if(left != null){
				printLIS(node.getLeft().getLeft());
				printLIS(node.getLeft().getRight());
			}
			if(right != null){
				printLIS(node.getRight().getLeft());
				printLIS(node.getRight().getRight());
			}
		}
		
		
	}
	
	
	
	
	
	public static void printTree(TreeNode root){
		if(root == null){
			return;
		}
		printTree(root.getLeft());
		System.out.print(root.getValue() + "\t");
		printTree(root.getRight());
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(30);
		TreeNode node6 = new TreeNode(60);
		TreeNode node4 = new TreeNode(40);
		TreeNode node5 = new TreeNode(50);
		TreeNode node7 = new TreeNode(70);
		TreeNode node8 = new TreeNode(80);
		
		node5.setLeft(node7);
		node5.setRight(node8);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setRight(node6);
		
		root.setLeft(node2);
		root.setRight(node3);
		
		printTree(root);
		
		System.out.println();
		
		System.out.println("size of LIS for given tree is "+getLIS(root));
		printLIS(root);
		
	}
}
