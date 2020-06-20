package com.avl.test;

public class AVLTree {

	static TreeNode root;

	public static class TreeNode {
		TreeNode leftNode;
		int data;
		int balanceFactor;
		TreeNode rightNode;

		public TreeNode(int data) {
			this.data = data;
		}

	}

	public static TreeNode createAVLTree(TreeNode root, int key) {

		TreeNode treeNode = null;

		if (AVLTree.root == null) {
			treeNode = new TreeNode(key);
			AVLTree.root = treeNode;
		}

		if (root == null) {
			treeNode = new TreeNode(key);
			return treeNode;
		}

		if (key == root.data) {
			System.out.println("Node already exists with key :" + key);
			return root;
		}

		else if (key < root.data) {
			root.leftNode = createAVLTree(root.leftNode, key);
		} else if (key > root.data) {
			root.rightNode = createAVLTree(root.rightNode, key);
		}

		return root;

	}

	public static void main(String[] args) {

	}
}
