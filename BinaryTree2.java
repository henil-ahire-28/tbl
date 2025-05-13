
import java.util.LinkedList;
import java.util.Queue;

class BTNode {
	private int data;
	private BTNode left, right;

	public BTNode() {
	}

	public BTNode(int d) {
		data = d;
		left = right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}
}

public class BinaryTree2 {
	private BTNode root;

	public void setRoot(BTNode r) {
		root = r;
	}

	public BTNode getRoot() {
		return root;
	}

	public BTNode createNode(int d) {
		return new BTNode(d);
	}

	public void insert_levelwise(int d) {
		BTNode new_node = new BTNode(d);
		if (root == null) {
			root = new_node;
			return;
		}
		Queue<BTNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BTNode iter = q.remove();
			if (iter.getLeft() == null) {
				iter.setLeft(new_node);
				return;
			} else {
				q.add(iter.getLeft());
			}
			if (iter.getRight() == null) {
				iter.setRight(new_node);
				return;
			} else {
				q.add(iter.getRight());
			}
		}
	}

	public void preOrder() {
		visit_preOrder(root);
	}

	private void visit_preOrder(BTNode r) {
		if (r == null)
			return;
		System.out.println(r.getData() + " ");
		visit_preOrder(r.getLeft());
		visit_preOrder(r.getRight());
	}

	public void inOrder() {
		visit_inOrder(root);
	}

	private void visit_inOrder(BTNode r) {
		if (r == null)
			return;
		visit_inOrder(r.getLeft());
		System.out.println(r.getData() + " ");
		visit_inOrder(r.getRight());
	}

	public void postOrder() {
		visit_postOrder(root);
	}

	private void visit_postOrder(BTNode r) {
		if (r == null)
			return;
		visit_postOrder(r.getLeft());
		visit_postOrder(r.getRight());
		System.out.println(r.getData() + " ");
	}

	public void display_levelwise() {
		if (root == null) {
			System.out.println("Tree is empty.");
			return;
		}
		Queue<BTNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BTNode iter = q.remove();
			System.out.print(iter.getData() + " ");
			if (iter.getLeft() != null)
				q.add(iter.getLeft());
			if (iter.getRight() != null)
				q.add(iter.getRight());
		}
		System.out.println();
	}

	public void leaf_nodes() {
		printLeafNodes(root);
	}

	private void printLeafNodes(BTNode node) {
		if (node == null)
			return;
		if (node.getLeft() == null && node.getRight() == null) {
			System.out.println(node.getData());
			return;
		}
		printLeafNodes(node.getLeft());
		printLeafNodes(node.getRight());
	}

	public void mirror() {
		mirrorTree(root);
	}

	private void mirrorTree(BTNode node) {
		if (node == null)
			return;
		mirrorTree(node.getLeft());
		mirrorTree(node.getRight());
		BTNode temp = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(temp);
	}

	public int sumOfNodes() {
		return computeSum(root);
	}

	private int computeSum(BTNode node) {
		if (node == null)
			return 0;
		return node.getData() + computeSum(node.getLeft()) + computeSum(node.getRight());
	}

	public int findMax() {
		return findMaxValue(root);
	}

	private int findMaxValue(BTNode node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int leftMax = findMaxValue(node.getLeft());
		int rightMax = findMaxValue(node.getRight());
		return Math.max(node.getData(), Math.max(leftMax, rightMax));
	}

	public int findMin() {
		return findMinValue(root);
	}

	private int findMinValue(BTNode node) {
		if (node == null)
			return Integer.MAX_VALUE;
		int leftMin = findMinValue(node.getLeft());
		int rightMin = findMinValue(node.getRight());
		return Math.min(node.getData(), Math.min(leftMin, rightMin));
	}

	public static void main(String[] args) {
		BinaryTree2 bt = new BinaryTree2();
		bt.insert_levelwise(10);
		bt.insert_levelwise(20);
		bt.insert_levelwise(30);
		bt.insert_levelwise(40);
		bt.insert_levelwise(50);
		System.out.println("Binary Tree (Level-wise):");
		bt.display_levelwise();
		System.out.println("Pre Order:");
		bt.preOrder();
		System.out.println("In Order:");
		bt.inOrder();
		System.out.println("Post Order:");
		bt.postOrder();
		System.out.println("Leaf Nodes:");
		bt.leaf_nodes();
		System.out.println("Sum of all nodes: " + bt.sumOfNodes());
		System.out.println("Maximum value: " + bt.findMax());
		System.out.println("Minimum value: " + bt.findMin());
		System.out.println("Mirror Image Tree (Level-wise):");
		bt.mirror();
		bt.display_levelwise();
	}
}