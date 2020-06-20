package com.bst.test;

public class BinarySearchTreeRecursive {

	static TreeNode root;

	public static class TreeNode {
		TreeNode leftChild;
		int data;
		TreeNode rightChild;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static TreeNode createBST(TreeNode node, int key) {

		TreeNode t = null;

		if (root == null) {
			t = new TreeNode(key);
			root = t;
			return t;
		}

		if (node == null) {
			t = new TreeNode(key);
			return t;
		}

		if (node.data == key) {
			System.out.println("Node already exists with data: " + key);
			return node;
		}

		if (key < node.data)
			node.leftChild = createBST(node.leftChild, key);

		else if (key > node.data)
			node.rightChild = createBST(node.rightChild, key);

		return node;
	}

	public static void inorder(TreeNode root) {

		if (root != null) {

			inorder(root.leftChild);
			System.out.print(root.data + " ");
			inorder(root.rightChild);

		}

	}

	public static TreeNode searchRecursive(TreeNode root, int key) {

		if (root == null)
			return null;

		if (key == root.data)
			return root;

		if (key < root.data)
			return searchRecursive(root.leftChild, key);

		else if (key > root.data)
			return searchRecursive(root.rightChild, key);

		return null;
	}

	public static TreeNode insertRecursive(TreeNode node, int key) {

		if (root == null)
			return null;

		if (node == null) {
			TreeNode t = new TreeNode(key);
			return t;
		}

		if (key == node.data) {
			System.out.println("already exists with key: " + key);
			return node;
		}

		if (key < node.data) {
			node.leftChild = insertRecursive(node.leftChild, key);
		} else if (key > node.data) {
			node.rightChild = insertRecursive(node.rightChild, key);
		}

		return node;
	}

	public static int height(TreeNode root) {

		if (root == null)
			return -1;

		int x = 0;
		int y = 0;

		x = height(root.leftChild);
		y = height(root.rightChild);

		return x > y ? x + 1 : y + 1;
	}

	public static TreeNode inorderPredecessor(TreeNode node) {

		if (node != null && node.rightChild != null)
			node = node.rightChild;

		return node;
	}

	public static TreeNode inorderSuccessor(TreeNode node) {

		if (node != null && node.leftChild != null)
			node = node.leftChild;

		return node;
	}

	public static TreeNode deleteRecursive(TreeNode root, int key) {

		TreeNode q = null;

		if (root == null)
			return null;

		if (root.leftChild == null && root.rightChild == null) {

			if (root == BinarySearchTreeRecursive.root)
				BinarySearchTreeRecursive.root = null;

			return null;
		}

		if (key < root.data)
			root.leftChild = deleteRecursive(root.leftChild, key);

		else if (key > root.data)
			root.rightChild = deleteRecursive(root.rightChild, key);

		else {

			if (height(root.leftChild) > height(root.rightChild)) {

				q = inorderPredecessor(root.leftChild);
				root.data = q.data;
				root.leftChild = deleteRecursive(root.leftChild, q.data);

			} else {

				q = inorderSuccessor(root.rightChild);
				root.data = q.data;
				root.rightChild = deleteRecursive(root.rightChild, q.data);

			}
		}

		return root;

	}

	public static void main(String[] args) {

		createBST(root, 23);
		createBST(root, 21);
		createBST(root, 20);
		createBST(root, 22);
		createBST(root, 25);
		createBST(root, 24);
		createBST(root, 26);

		/*
		 * inorder(root);
		 * 
		 * System.out.println();
		 * 
		 * TreeNode searchedNode = searchRecursive(root, 90); if (searchedNode != null)
		 * { System.out.println(searchedNode.leftChild != null ?
		 * searchedNode.leftChild.data : null);
		 * System.out.println(searchedNode.rightChild != null ?
		 * searchedNode.rightChild.data : null); } else {
		 * System.out.println("Not found with key: " + 90); }
		 * 
		 * insertRecursive(root, 35);
		 * 
		 * insertRecursive(root, 60);
		 * 
		 * insertRecursive(root, 35);
		 * 
		 * inorder(root);
		 */

		/*
		 * deleteRecursive(root, 20);
		 * 
		 * inorder(root);
		 */

//		insertRecursive(root, 17);

		inorder(root);

		System.out.println(height(root));

	}

}
