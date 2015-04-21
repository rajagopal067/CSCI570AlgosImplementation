
public class TreeNode {

	private int value;
	private TreeNode left;
	private TreeNode right;
	private int LSS;
	
	public TreeNode(int value) {
		super();
		this.value = value;
	}
	public int getLSS() {
		return LSS;
	}
	public void setLSS(int lSS) {
		LSS = lSS;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	
	
	
	
}
