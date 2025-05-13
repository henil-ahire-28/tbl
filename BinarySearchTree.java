
class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int item) {
        data = item;
        left = right = null;
    }
}


public class BinarySearchTree {
	private BSTNode root;

	public void insert(int data) {
		root = insertRec(root, data);
	}

	private BSTNode insertRec(BSTNode root, int data) {
		if (root == null) {
			return new BSTNode(data);
		}
		if (data < root.data) {
			root.left = insertRec(root.left, data);
		} else if (data > root.data) {
			root.right = insertRec(root.right, data);
		}
		return root;
	}

	public boolean search(int key) {
		return searchRec(root, key);
	}

	private boolean searchRec(BSTNode root, int key) {
		if (root == null)
			return false;
		if (root.data == key)
			return true;
		if (key < root.data)
			return searchRec(root.left, key);
		else
			return searchRec(root.right, key);
	}

	public void inorder() {
		inorderRec(root);
		System.out.println();
	}

	private void inorderRec(BSTNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}

	public void preorder() {
		preorderRec(root);
		System.out.println();
	}

	private void preorderRec(BSTNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}

	public void postorder() {
		postorderRec(root);
		System.out.println();
	}

	private void postorderRec(BSTNode root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data + " ");
		}
	}

	public int findMin() {
		if (root == null)
			throw new RuntimeException("Tree is empty");
		BSTNode current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current.data;
	}

	public int findMax() {
		if (root == null)
			throw new RuntimeException("Tree is empty");
		BSTNode current = root;
		while (current.right != null) {
			current = current.right;
		}
		return current.data;
	}

	public void delete(int key) {
		root = deleteRec(root, key);
	}

	private BSTNode deleteRec(BSTNode root, int key) {
		if (root == null)
			return null;
		if (key < root.data) {
			root.left = deleteRec(root.left, key);
		} else if (key > root.data) {
			root.right = deleteRec(root.right, key);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}
		return root;
	}

	private int minValue(BSTNode root) {
		int min = root.data;
		while (root.left != null) {
			root = root.left;
			min = root.data;
		}
		return min;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(70);
		bst.insert(20);
		bst.insert(40);
		bst.insert(60);
		bst.insert(80);
		System.out.println("Inorder traversal:");
		bst.inorder();
		System.out.println("Preorder traversal:");
		bst.preorder();
		System.out.println("Postorder traversal:");
		bst.postorder();
		System.out.println("Minimum value: " + bst.findMin());
		System.out.println("Maximum value: " + bst.findMax());
		System.out.println("Searching for 60: " + bst.search(60));
		System.out.println("Deleting 70...");
		bst.delete(70);
		System.out.println("Inorder after deletion:");
		bst.inorder();
	}
}