package com.queue.test;

import com.tree.test.TreeUsingQueue.TreeNode;

public class QueueUsingArray {

	public static class Queue {

		private int size;
		private int front = -1;
		private int rear = -1;
		private TreeNode[] q;

		public Queue(int size) {
			this.size = size;
			this.q = new TreeNode[size];
		}

	}

	public static boolean isFull(Queue queue) {
		if (queue.rear == queue.size - 1)
			return true;

		return false;
	}

	public static boolean isEmpty(Queue queue) {
		if (queue.front == queue.rear)
			return true;

		return false;
	}

	public static void enqueue(Queue queue, TreeNode treeNode) {

		if (isFull(queue))
			throw new IllegalStateException("Queue is full");

		queue.rear++;
		queue.q[queue.rear] = treeNode;
	}

	public static TreeNode dequeue(Queue queue) {

		if (isEmpty(queue))
			throw new IllegalStateException("Queue is empty");

		queue.front++;

		return queue.q[queue.front];

	}

	public static void display(Queue queue) {

		if (!isEmpty(queue)) {

			for (int i = queue.front + 1; i <= queue.rear; i++) {
				System.out.print(queue.q[i] + " ");
			}
		}
	}

}
