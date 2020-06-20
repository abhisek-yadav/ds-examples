package com.bst.test;

public class BinarySearchTreeIterative {

	static TreeNode root;

	public static class TreeNode {
		TreeNode leftChild;
		int data;
		TreeNode rightChild;

		public TreeNode(int data) {
			this.data = data;
		}

	}

	public static void createBSTIterative(TreeNode root, int key) {

		TreeNode prevNode = null;
		TreeNode treeNode = null;

		if (BinarySearchTreeIterative.root == null) {

			treeNode = new TreeNode(key);
			BinarySearchTreeIterative.root = treeNode;
			return;
		}

		while (root != null) {

			if (key < root.data) {
				prevNode = root;
				root = root.leftChild;

			} else if (key > root.data) {
				prevNode = root;
				root = root.rightChild;

			}
		}

		if (key < prevNode.data) {
			treeNode = new TreeNode(key);
			prevNode.leftChild = treeNode;

		} else if (key > prevNode.data) {
			treeNode = new TreeNode(key);
			prevNode.rightChild = treeNode;
		}

	}

	public static TreeNode searchIterative(TreeNode root, int key) {

		while (root != null) {

			if (key == root.data)
				return root;
			else if (key < root.data)
				root = root.leftChild;
			else
				root = root.rightChild;
		}

		return null;

	}

	public static void inorder(TreeNode root) {

		if (root == null)
			return;

		inorder(root.leftChild);
		System.out.print(root.data + " ");
		inorder(root.rightChild);
	}

	public static void main(String[] args) {

		createBSTIterative(root, 30);
		createBSTIterative(root, 10);
		createBSTIterative(root, 15);
		createBSTIterative(root, 40);
		createBSTIterative(root, 35);
		createBSTIterative(root, 45);

		inorder(root);

		System.out.println(searchIterative(root, 30).rightChild.data);
	}
}
