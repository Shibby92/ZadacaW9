package Tree;

/**
 * Kreiranje Binarytree-a
 * 
 * @author harisarifovic
 *
 */
public class Tree {
	private Node root;

	public Tree() {
		this.root = null;
	}

	/**
	 * Dodaje novi broj u stablo
	 * 
	 * @param value
	 *            Vrijednost koja se dodaje
	 */
	public void add(int value) {
		// Ukoliko je prazno stablo
		if (root == null) {
			root = new Node(value);
		} else {
			// Poziva funkciju ispod
			add(root, value);
		}
	}

	/**
	 * Dodavanje vrijednosti u stablo
	 * 
	 * @param current
	 *            Trenutni node
	 * @param value
	 *            Vrijednost koja se dodaje
	 */
	public void add(Node current, int value) {
		if (current == null) {
			current = new Node(value);
			return;
		}
		if (value <= current.value) {
			if (current.left == null) {
				current.left = new Node(value);
				return;
			}
			add(current.left, value);
		} else {
			if (current.right == null) {
				current.right = new Node(value);
				return;
			}
			add(current.right, value);

		}
	}

	public Node getRoot() {
		return root;
	}

	/**
	 * Ispisuje vrijednosti stabla
	 * 
	 * @param toPrint
	 *            Node koji se poziva
	 */
	public void printTree(Node toPrint) {
		if (toPrint == null) {
			return;
		}
		printTree(toPrint.left);
		System.out.println(toPrint.value);
		printTree(toPrint.right);
	}

	/**
	 * Ispituje da li se neka vrijednost nalazi u stablu
	 * 
	 * @param value
	 *            Vrijednost koja se trazi
	 * @param find
	 *            Node koji se proslijedjuje
	 * @return True/false ovisno od ishoda
	 */
	public boolean contains(int value, Node find) {
		if (find == null) {
			return false;
		}
		if (find.value == value) {
			return true;
		} else if (value < find.value) {
			return contains(value, find.left);
		} else {
			return contains(value, find.right);
		}
	}

	

	/**
	 * Da li je stablo identicno drugom
	 * 
	 * @param root1
	 *            Stablo
	 * @param root2
	 *            Stablo 2
	 * @return True/false ovisno od ishoda
	 */
	boolean areIdentical(Node root1, Node root2) {
		/* base cases */
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		/*
		 * Check if the data of both roots is same and data of left and right
		 * subtrees are also same
		 */
		return (root1.value == root2.value
				&& areIdentical(root1.left, root2.left) && areIdentical(
					root1.right, root2.right));
	}

	/* This function returns true if S is a subtree of T, otherwise false */
	boolean isSubtree(Node T,Node S) {
		/* base cases */
		if (S == null)
			return true;

		if (T == null)
			return false;

		/* Check the tree with root as current node */
		if (areIdentical(T, S))
			return true;

		/*
		 * If the tree with root as current node doesn't match then try left and
		 * right subtrees one by one
		 */
		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}
	public Node findLca(Node node, int t1, int t2) {
	    if(node == null) {
	        return null;
	    }
	    if(node.value <= t2 && node.value <= t1) {
	        // both targets are left
	        return findLca(node.left, t1, t2);
	    } else if (node.value > t2 && node.value > t1) {
	        // both targets are right
	        return findLca(node.right, t1, t2);
	    } else {
	        // either we are diverging or both targets are equal
	        // in both cases so we've found the LCA
	        // check for actual existence of targets here, if you like
	        return node;
	    }
	}
}
