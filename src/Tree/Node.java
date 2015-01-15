package Tree;

/**
 * Klasa Node
 * 
 * @author harisarifovic
 *
 */
public class Node {

	public int value;
	public Node left;
	public Node right;

	public Node() {
		this.value = 0;
		this.left = null;
		this.right = null;

	}

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
