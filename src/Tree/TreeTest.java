package Tree;

public class TreeTest {

	public static void main(String[] args) {
		Tree test = new Tree();
		test.add(4);
		test.add(1);
		test.add(2);
		test.add(5);
		test.add(7);
		test.add(66);
		test.add(24);
		test.add(77);
		test.add(17);
		test.add(3);
		test.add(9);
		Tree test2 = new Tree();
		test2.add(66);
		test2.add(24);
		test2.add(77);
		test2.add(17);
		test2.add(9);
		isSubTreeTest(test, test2);
		Tree test3 = new Tree();
		test3.add(66);
		test3.add(24);
		test3.add(77);
		test3.add(17);
		isSubTreeTest(test, test3);
		findLcaTest(test, 2, 17);

	}

	public static void isSubTreeTest(Tree tree, Tree subtree) {
		System.out.println("Testing subtree method:");
		System.out.println(tree.isSubtree(tree.getRoot(), subtree.getRoot()));
		System.out.println("------------------");
	}

	public static void findLcaTest(Tree test, int value1, int value2) {
		System.out.println("Testing lca mehtod:");
		Node ancestor = test.findLca(test.getRoot(), value1, value2);
		System.out.println(ancestor.value);
		System.out.println("------------------");
	}
}
