package com.tree.test;

import java.util.ArrayList;
import java.util.List;

import com.queue.test.QueueUsingArray;
import com.queue.test.QueueUsingArray.Queue;
import com.stack.test.StackUsingArray;
import com.stack.test.StackUsingArray.Stack;
import com.tree.test.TreeUsingQueue.TreeNode;

public class IterativeTreeTraversals {

	static Stack stack = new Stack(50);

	public static void iterativePreOrder(TreeNode root) {

		while (!StackUsingArray.isEmpty(stack) || root != null) {

			if (root != null) {
				System.out.print(root.data + " ");
				StackUsingArray.push(stack, root);
				root = root.leftChild;
			} else {
				root = StackUsingArray.pop(stack);
				root = root.rightChild;
			}
		}

	}

	public static void iterativeInOrder(TreeNode root) {

		while (!StackUsingArray.isEmpty(stack) || root != null) {

			if (root != null) {
				StackUsingArray.push(stack, root);
				root = root.leftChild;
			} else {
				root = StackUsingArray.pop(stack);
				System.out.print(root.data + " ");
				root = root.rightChild;

			}
		}

	}

	/**
	 * Implemented using two stacks
	 * 
	 * @param root
	 */
	public static void iterativePostOrder(TreeNode root) {

		if (root == null)
			return;

		Stack stack1 = new Stack(50);
		Stack stack2 = new Stack(50);

		StackUsingArray.push(stack1, root);

		while (!StackUsingArray.isEmpty(stack1)) {
			TreeNode node = StackUsingArray.pop(stack1);
			StackUsingArray.push(stack2, node);

			if (node.leftChild != null) {
				StackUsingArray.push(stack1, node.leftChild);
			}
			if (node.rightChild != null) {
				StackUsingArray.push(stack1, node.rightChild);
			}
		}

		while (!StackUsingArray.isEmpty(stack2)) {
			TreeNode node = StackUsingArray.pop(stack2);
			System.out.print(node.data + " ");
		}

	}

	public static void iterativeLevelOrder(TreeNode root) {

		Queue queue = new Queue(50);
		QueueUsingArray.enqueue(queue, root);
		System.out.print(root.data + " ");

		while (!QueueUsingArray.isEmpty(queue)) {
			TreeNode node = QueueUsingArray.dequeue(queue);

			if (node.leftChild != null) {
				System.out.print(node.leftChild.data + " ");
				QueueUsingArray.enqueue(queue, node.leftChild);
			}

			if (node.rightChild != null) {
				System.out.print(node.rightChild.data + " ");
				QueueUsingArray.enqueue(queue, node.rightChild);
			}
		}
	}

	public static void main(String[] args) {

		List<Integer> nodes = new ArrayList<>();
		nodes.add(1);
		nodes.add(2);
		nodes.add(3);
		nodes.add(4);
		nodes.add(5);
		nodes.add(6);
		nodes.add(7);

		TreeUsingQueue.createTree(nodes);

		/*
		 * iterativePreOrder(TreeUsingQueue.root);
		 * 
		 * System.out.println();
		 * 
		 * iterativeInOrder(TreeUsingQueue.root);
		 * 
		 * System.out.println();
		 * 
		 * 
		 * iterativeLevelOrder(TreeUsingQueue.root);
		 * 
		 * System.out.println();
		 */

		iterativePostOrder(TreeUsingQueue.root);
	}
}
